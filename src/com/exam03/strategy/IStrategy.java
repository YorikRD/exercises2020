package com.exam03.strategy;

import java.io.Serializable;

public interface IStrategy extends Serializable {

    public String getTxt(int choice);
    public int[] getLinks(int choice);


}
