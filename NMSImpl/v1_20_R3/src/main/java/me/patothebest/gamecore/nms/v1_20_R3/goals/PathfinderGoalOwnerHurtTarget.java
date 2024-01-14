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

public class PathfinderGoalOwnerHurtTarget extends PathfinderGoalTarget {

    private final EntityLiving owner;
    private EntityLiving target;
    private int number;

    public PathfinderGoalOwnerHurtTarget(EntityLiving owner, EntityCreature entityCreature) {
        super(entityCreature, false);
        this.owner = owner;
        this.a(1);
    }

    @Override
    public boolean a() {
        this.target = owner.getLastDamager();
        int i = owner.db();
        return i != this.number && this.a(this.target, PathfinderTargetCondition.a);
    }

    @Override
    public void c() {
        this.e.setGoalTarget(this.target, EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, true);
        this.number = owner.db();
        super.c();
    }
}
