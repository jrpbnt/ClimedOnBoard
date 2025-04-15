package inosystem.climed.climedonboard.config;

import inosystem.climed.climedonboard.model.RoleEntity;
import inosystem.climed.climedonboard.model.UserEntity;
import inosystem.climed.climedonboard.repository.RoleRepository;
import inosystem.climed.climedonboard.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class StartupInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        return args -> {
            List<String> rolesNomes = List.of(
                    "ROLE_ADMIN",
                    "ROLE_RECEPCAO",
                    "ROLE_FINANCEIRO",
                    "ROLE_ENFERMEIRO",
                    "ROLE_MEDICO"
            );

            for (String nome : rolesNomes) {
                roleRepository.findByAuthority(nome).orElseGet(() ->
                        roleRepository.save(new RoleEntity(null, nome)));
            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                UserEntity admin = new UserEntity();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setEnabled(true);

                Set<RoleEntity> roles = new HashSet<>();
                roleRepository.findByAuthority("ROLE_ADMIN").ifPresent(roles::add);
                admin.setRoles(roles);

                userRepository.save(admin);
            }
        };
    }
}