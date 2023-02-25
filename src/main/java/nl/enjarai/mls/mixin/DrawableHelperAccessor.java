package nl.enjarai.mls.mixin;

import net.minecraft.client.gui.DrawableHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.joml.Matrix4f;

@Mixin(DrawableHelper.class)
public interface DrawableHelperAccessor {
    @Invoker("drawTexturedQuad")
    static void loadingScreen$drawTexturedQuad(Matrix4f matrices, int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1) {
        throw new UnsupportedOperationException();
    }
}
