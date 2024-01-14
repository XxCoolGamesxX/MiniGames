package me.patothebest.gamecore.nms.v1_20_R3.goals;

//import net.minecraft.server.v1_20_R3.EntityCreature;
import net.minecraft.world.entity.EntityCreature;
//import net.minecraft.server.v1_20_R3.EntityLiving;
import net.minecraft.world.entity.EntityLiving;
//import net.minecraft.server.v1_20_R3.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
//import net.minecraft.server.v1_20_R3.PathfinderTargetCondition;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

public class PathfinderGoalOwnerHurtByTarget extends PathfinderGoalTarget {

    private final EntityLiving owner;
    private EntityLiving target;
    private int c;

    public PathfinderGoalOwnerHurtByTarget(EntityLiving owner, EntityCreature entityCreature) {
        super(entityCreature, false);
        this.owner = owner;
        this.a(1);
    }

    public boolean a() {
        this.target = owner.getLastDamager();
        int i = owner.cZ();
        return i != this.c && this.a(this.target, PathfinderTargetCondition.a);
    }

    public void c() {
        this.e.setGoalTarget(this.target, EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true);
        this.c = owner.cZ();
        super.c();
    }
}
