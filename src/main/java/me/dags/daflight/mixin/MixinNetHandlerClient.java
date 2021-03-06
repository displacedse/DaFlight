package me.dags.daflight.mixin;

import me.dags.daflight.DaFlight;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.SPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author dags <dags@dags.me>
 */
@Mixin(NetHandlerPlayClient.class)
public abstract class MixinNetHandlerClient
{
    @Inject(method = "handleCustomPayload(Lnet/minecraft/network/play/server/SPacketCustomPayload;)V", at = @At("RETURN"))
    public void handleCustomPayload(SPacketCustomPayload packetIn, CallbackInfo callbackInfo)
    {
        DaFlight.instance().messageHandler().handlePacket(packetIn.getChannelName(), packetIn.getBufferData());
    }
}
