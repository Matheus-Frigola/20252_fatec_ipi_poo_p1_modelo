package br.gov.sp.cps.fatecipiranga;

import lombok.Getter;

@Getter
public class Faca {
    private int dano = 1;

    public int atacar () {
        return this.getDano();
    }
}
