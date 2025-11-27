package br.gov.sp.cps.fatecipiranga;

import lombok.Getter;

@Getter
public class Pistola {
    private int dano = 2;

    public int atacar() {
        return this.getDano();
    }
}
