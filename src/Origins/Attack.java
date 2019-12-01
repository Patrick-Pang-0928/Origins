package Origins;

public interface Attack {
    void attack(Entity declare, Entity hostile);
    void attack_priority(Entity declare, Entity hostile);
    void damage(Entity hostile, Entity declare);
    boolean miss(Entity declare, Entity hostile);
    boolean dead(Entity entity);
}
