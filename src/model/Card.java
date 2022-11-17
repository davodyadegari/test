package model;

import Exeptions.InvalidPasswordException;

import java.time.LocalDate;
import java.util.Random;

public class Card {
    private String cardNumber;
    private String cvv2;
    private LocalDate expiredDate;
    private String password;

    public Card(String password) {
        Random random = new Random();
        int num = random.nextInt(10000000,99999999);
        this.cardNumber = "50730819"+num;
        this.cvv2 = String.valueOf(random.nextInt(4));
        this.expiredDate = LocalDate.now().plusYears(3);
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean validation(String pass){
        return pass.equals(this.password);
    }



    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", expiredDate=" + expiredDate +
                ", password='" + password + '\'' +
                '}';
    }
}
