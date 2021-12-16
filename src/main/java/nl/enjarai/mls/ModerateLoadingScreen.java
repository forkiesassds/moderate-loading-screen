/*
 * Copyright (c) 2021 enjarai
 * Copyright (c) 2021 darkerbit
 * Copyright (c) 2021 wafflecoffee
 * Copyright (c) 2020 TeamMidnightDust (MidnightConfig only)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.enjarai.mls;

import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import nl.enjarai.mls.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import nl.enjarai.mls.config.ScreenTypes;
import nl.enjarai.mls.screens.LoadingScreen;
import org.apache.commons.lang3.Validate;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ModerateLoadingScreen implements ClientModInitializer {
    public static final String MODID = "moderate-loading-screen";

    @Override
    public void onInitializeClient() {
        ModConfig.init();
    }

    public static NativeImageBackedTexture getIconTexture(ModContainer iconSource, String iconPath) {
        try {
            Path path = iconSource.getPath(iconPath);
            try (InputStream inputStream = Files.newInputStream(path)) {
                NativeImage image = NativeImage.read(Objects.requireNonNull(inputStream));
                Validate.validState(image.getHeight() == image.getWidth(), "Must be square icon");
                return new NativeImageBackedTexture(image);
            }

        } catch (Throwable t) {
            return null;
        }
    }
}
