package model;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.ArrayList;

public class SQUAD {

    private static ArrayList<SQUAD> instances =new ArrayList<>();
    private  ArrayList<Hero> heros = new ArrayList<>();
    private String squadName;
    private Hero hero;
    private Integer id;
    private boolean check = false;
    private boolean checkHero = false;
    private int instance ;




    public SQUAD(String squadName, Hero hero) {
        this.squadName = squadName;
        this.hero = hero;
        this.id = instances.size();

        for (int i = 0; i < instances.size(); i++) {

            //if squad entered is existent in instances
            if (instances.get(i).squadName.equals(squadName)) {//squad1
                check = true;
                instance = i;

                for (int x = 0; x < instances.get(i).heros.size(); x++) {

                    if (instances.get(i).heros.get(x).getName().equals(hero.getName())) {

                        showMessageDialog(null, "This Hero is in another squad");
                        checkHero = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!check){
            instances.add(this);
            showMessageDialog(null, "The Squad has been created with the new hero");
        }
        if (!checkHero){
            instances.get(instance).heros.add(hero);
            showMessageDialog(null, "The hero has ben added to the squad");

        }
    }
    //showMessageDialog(null, "The Hero has been added to the new squad");


    public static ArrayList<SQUAD> getAll() {
        return instances;
    }

    public ArrayList<Hero> getHeros() {
        return heros;
    }
}