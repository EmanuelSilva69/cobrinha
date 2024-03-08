public class arena {
    final int CONTA_LINHA, CONTA_COLUNA;
    private celula[][] celulas;
    public arena(int contalinha, int contacoluna){
        CONTA_LINHA = contalinha;
        CONTA_COLUNA=contacoluna;
        celulas= new celula[CONTA_LINHA][CONTA_COLUNA];
        for(int linha=0;linha<CONTA_LINHA;linha++){
            for(int coluna=0;coluna<CONTA_COLUNA;coluna++){
                celulas[linha][coluna]=new celula(linha,coluna);
            }
        }
    }

    public celula[][] getCelulas() {
        return celulas;
    }

    public void setCelulas(celula[][] celulas) {
        this.celulas = celulas;
    }
    public void geracaodecomida(){
        System.out.println("Gerando comida.... (♨\uFE0F)");
        int linha=0,coluna=0;
        while(true){
            linha=(int)(Math.random() * CONTA_LINHA);
            coluna=(int)(Math.random() * CONTA_COLUNA);
            if(celulas[linha][coluna].getCelltype() != celulaType.NODULOCOBRA)
                break;
        }
        celulas[linha][coluna].setCellType(celulaType.FOOD);
        System.out.println("Comida está em " + linha + " " + coluna );
    }

}
