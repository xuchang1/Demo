package netty_demo.encoder_demo;

import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ByteToStringCodec extends CombinedChannelDuplexHandler<StringDecoder, StringEncoder> {

    public ByteToStringCodec() {
        super(new StringDecoder(), new StringEncoder());
    }
}
