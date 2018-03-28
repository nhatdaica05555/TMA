package com.example.home.demobancotuong;

import java.sql.Struct;

/**
 * Created by HOME on 3/28/2018.
 */

public class BanCo {
   public Struct Oco;
   public static Oco[,] ViTri = new Oco[10,9];

    public BanCo(Struct oco) {
        Oco = oco;
    }

    public static void ResetBanco(){}
    public static void ResetCanMove(){}
}
