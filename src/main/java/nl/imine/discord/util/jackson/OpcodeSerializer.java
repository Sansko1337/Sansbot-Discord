package nl.imine.discord.util.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nl.imine.discord.gateway.messages.GatewayOpcode;

import java.io.IOException;

public class OpcodeSerializer extends StdSerializer<GatewayOpcode> {

    public OpcodeSerializer() {
        super(GatewayOpcode.class);
    }

    @Override
    public void serialize(GatewayOpcode value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getCode());
    }
}
