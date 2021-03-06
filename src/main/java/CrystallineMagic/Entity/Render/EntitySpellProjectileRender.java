package CrystallineMagic.Entity.Render;

import CrystallineMagic.Entity.EntitySpellProjectile;
import CrystallineMagic.Main.ModItems;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;

public class EntitySpellProjectileRender extends Render {
    @Override
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
        IIcon iicon = ModItems.SpellIconItem.getIconFromDamage(0);

        if (entity.worldObj.isRemote) {
            if (entity instanceof EntitySpellProjectile) {
                EntitySpellProjectile ent = (EntitySpellProjectile) entity;

                if (iicon != null && ent.canRender()) {
                    GL11.glPushMatrix();

                    GL11.glTranslatef((float) x, (float) y, (float) z);
                    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                    GL11.glEnable(GL11.GL_BLEND);

                    float scale = 0.5F;
                    GL11.glScalef(scale, scale, scale);

                    this.bindEntityTexture(entity);

                    Color c = ent.getComponentColor();

                    GL11.glPushMatrix();
                    this.drawItem(iicon, c);
                    GL11.glPopMatrix();

                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glColor3f(1.0F, 1.0F, 1.0F);
                    GL11.glDisable(GL12.GL_RESCALE_NORMAL);
                    GL11.glPopMatrix();
                }


            }
        }


    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return TextureMap.locationItemsTexture;
    }

    private void drawItem(IIcon icon, Color color)
    {
        float f = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;

        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();

        float d1 = (float) ((double) color.getRed() / 255), d2 = (float) ((double) color.getGreen() / 255), d3 = (float) ((double) color.getBlue() / 255);
        tessellator.setColorRGBA_F(d1, d2, d3, 0.5F);

        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
        tessellator.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
        tessellator.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
        tessellator.draw();
    }
}
