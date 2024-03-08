import java.util.LinkedList;
public class Cobra {
    private LinkedList<celula> partedacobra = new LinkedList<>();
    private celula cabecinha;
    public Cobra(celula initPos){
        cabecinha = initPos;
        partedacobra.add(cabecinha);
        cabecinha.setCellType(celulaType.NODULOCOBRA);

    }
    public void crescer(){
        partedacobra.add(cabecinha);
    }
    public void mover(celula proxcelula){
        System.out.print("Cobrinha se movendo para "+proxcelula.getLinha() + " " +proxcelula.getColuna());
        celula rabo = partedacobra.removeLast();
        rabo.setCellType(celulaType.EMPTY);
        cabecinha=proxcelula;
        cabecinha.setCellType(celulaType.NODULOCOBRA);
        partedacobra.addFirst(cabecinha);
    }
    public boolean Batebate(celula proxcelula){
        System.out.println("verificando batida");
        for(celula celula : partedacobra){
            if(celula == proxcelula){
                return true;
            }
        }
        return false;
    }

    public LinkedList<celula> getPartedacobra() {
        return partedacobra;
    }

    public void setPartedacobra(LinkedList<celula> partedacobra) {
        this.partedacobra = partedacobra;
    }
    public celula getCabecinha(){
        return cabecinha;
    }
public void setCabecinha(celula cabecinha){
        this.cabecinha=cabecinha;
}

}
