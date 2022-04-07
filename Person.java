package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Person {
    String name;
    String gender;

    Person father;
    Person mother;


     Person(String name , String gender)
    {
        this.name = name;
        this.gender = gender;
    }


    Person(String name, String gender, String father, String mother)
    {
        this.name = name;
        this.gender = gender;
        this.father = new Person(father, "male");
        this.mother = new Person(mother , "female");
    }





    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<List<String>> str = new ArrayList<>();


        while(scanner.hasNextLine() == true)
        {
            String temp = scanner.nextLine();
            if("".equals(temp)) break;
            str.add(Arrays.asList(temp.split(",")));

        }

        System.out.println("Enter target name");
        String target = scanner.nextLine();
        scanner.close();


        List<Person> list = new ArrayList<Person>();

        for(List<String> s : str)
        {
            list.add(new Person(s.get(0),s.get(1),s.get(2),s.get(3)));
        }






        Person targetPerson = null;

        for(Person p : list)
        {
            if(p.name.equals(target)) {
                targetPerson = p;
                break;
            }
        }

        String oppositeGender = (targetPerson.gender.equals("male"))?"female":"male";


        Person dad = targetPerson.father;
        Person mom = targetPerson.mother;
        Person aunt = null;
        Person uncle = null;
        Person grandFatherDad = null;
        Person grandFatherMom = null;



        for(Person p : list) {

            if(dad.name.equals(p.name)) {
                grandFatherDad = p.father;
            }
            if(mom.name.equals(p.name)) {
                grandFatherMom = p.father;
            }
        }


        for(Person p : list) {
            if(grandFatherDad != null && grandFatherDad.name.equals(p.father.name) && (!p.name.equals(dad.name)) ) {
                aunt = p;
            }
            if(grandFatherMom != null && grandFatherMom.name.equals(p.father.name) && (!p.name.equals(mom.name))) {
                uncle = p;
            }
        }


        if(aunt != null)
        {
            for(Person p : list) {
                if(p.mother.name.equals(aunt.name)&& p.gender.equals(oppositeGender)) {
                    System.out.println(p.name);
                }
            }

        }


        else if(uncle != null)
        {
            for(Person p : list) {
                if(p.father.name.equals(uncle.name) && p.gender.equals(oppositeGender)) {
                    System.out.println(p.name);
                }
            }

        }

        else System.out.println("No matches found!!");








    }

}
