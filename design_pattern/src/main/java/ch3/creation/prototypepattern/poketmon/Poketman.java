package ch3.creation.prototypepattern.poketmon;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Poketman {

    @AllArgsConstructor
    static class monster implements Cloneable {
        private String name;
        private List<Skill> skills;
        private Integer HP;

        @Override
        public monster clone() {
            // 얕은 복사
            ArrayList<Skill> copySkills = new ArrayList<>();
            copySkills.addAll(this.skills);
            return new monster(this.name, copySkills, this.HP);

            // 깊은 복사
//                List<Skill> copySkills = this.skills.stream().map(skill -> skill.clone()).collect(Collectors.toList());
//                return new monster(this.name, copySkills, this.HP);
        }
    }

    ;

    @AllArgsConstructor
    private static class Skill implements Cloneable {
        private String name;
        private Integer maxPP;
        private Integer PP;
        private Integer damage;

        @Override
        public Skill clone() {
            return new Skill(this.name, this.maxPP, this.PP, this.damage);
        }
    }

    public static void main(String[] args) {
        List<Skill> 파이리_skills = new ArrayList<Skill>();
        파이리_skills.add(new Skill("화염방사", 10, 5, 100));
        monster 파이리 = new monster("파이리", 파이리_skills, 80);

        List<Skill> 메타몽_skills = new ArrayList<>();
        메타몽_skills.add(new Skill("변신", 5, 5, 0));
        monster 메타몽 = new monster("메타몽", 메타몽_skills, 40);

        // 메타몽.doSkill - 변신
        메타몽 = 파이리.clone();
    }
}

    