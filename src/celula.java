public class celula {
   private final int coluna,linha;
   private celulaType tipocelula;
   public celula(int coluna, int linha){
      this.coluna=coluna;
      this.linha=linha;
   }
   public celulaType getCelltype(){
      return tipocelula;
   }
   public void setCellType (celulaType tipocelula){
      this.tipocelula=tipocelula;
   }
   public int getColuna(){return coluna;}

   public int getLinha() {
      return linha;
   }
}
