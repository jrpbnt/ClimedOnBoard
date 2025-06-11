package inosystem.climed.climedonboard.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class EspecialidadeDTODeserializer extends JsonDeserializer<EspecialidadeDTO> {
    @Override
    public EspecialidadeDTO deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        Long id = parser.getLongValue(); // Lê o valor numérico do campo id
        return new EspecialidadeDTO(id); // Cria uma instância de EspecialidadeDTO com o id
    }
}
