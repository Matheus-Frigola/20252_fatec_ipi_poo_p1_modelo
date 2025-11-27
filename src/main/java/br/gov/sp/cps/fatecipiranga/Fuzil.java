package br.gov.sp.cps.fatecipiranga;

import lombok.Getter;

@Getter
public class Fuzil {
    private int dano = 3;

    public int atacar() {
        return this.getDano();
    }
}
