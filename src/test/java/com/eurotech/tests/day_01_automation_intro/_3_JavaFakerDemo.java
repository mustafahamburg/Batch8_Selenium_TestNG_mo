package com.eurotech.tests.day_01_automation_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class _3_JavaFakerDemo {
    public static void main(String[] args) {
        // mock data uretmek icin kull(sahte data)
        Faker faker=new Faker();
        // sahte isim uretelim
        String fullName=faker.name().fullName();
        System.out.println("fullName = " + fullName); //fullName = Eneida Thiel DVM
        // sahte sehir uretelim
        String city = faker.address().city();
        System.out.println("city = " + city);
        // kredi kart no
        String creditCard = faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);
        // american express
        String creditCard1 = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("creditCard1 = " + creditCard1);
        // sifre
        String password = faker.internet().password();
        System.out.println("password = " + password);
        //rakam,harf vs istenen
        String password1 = faker.internet().password(8, 16, true, true, true);
        System.out.println("password1 = " + password1);
        // belli bir degerle baslayan "AB123*"
       String password3 = "AB123*"+faker.internet().password();
        System.out.println("password3 = " + password3);
        // email..
        String emailAddress = faker.internet().emailAddress();
        System.out.println("emailAddress = " + emailAddress);//emailAddress = tammi.kulas@yahoo.com


    }

}
