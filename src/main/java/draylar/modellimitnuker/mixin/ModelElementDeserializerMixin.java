package draylar.modellimitnuker.mixin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ModelElement.Deserializer.class)
public abstract class ModelElementDeserializerMixin {

    @Shadow protected abstract Vector3f deserializeVec3f(JsonObject object, String name);

    /**
     * @author Draylar
     */
    @Overwrite
    private float deserializeRotationAngle(JsonObject object) {
        return JsonHelper.getFloat(object, "angle");
    }

    /**
     * @author Draylar
     */
    @Overwrite
    private Vector3f deserializeFrom(JsonObject object) {
        return deserializeVec3f(object, "from");
    }

    /**
     * @author Draylar
     */
    @Overwrite
    private Vector3f deserializeTo(JsonObject object) {
        return this.deserializeVec3f(object, "to");
    }
}
