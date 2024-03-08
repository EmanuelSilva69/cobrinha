import java.util.Objects;
import java.util.Scanner;
public class Jogo {
    Scanner Controle = new Scanner(System.in);
    public static final int direcao_naum=0,direcao_direita=1,direcao_esquerda=-1,direcao_cima=2,direcao_baixo=-2;
    private Cobra cobra;
    private arena arena1;
    private int direcao;
    private boolean fimdogame;
    public Jogo(Cobra cobra, arena arena1){
        this.cobra= cobra;
        this.arena1 = arena1;
    }

    public Cobra getCobra() {
        return cobra;
    }

    public void setCobra(Cobra cobra) {
        this.cobra = cobra;
    }

    public arena getArena1() {
        return arena1;
    }

    public void setArena1(arena arena1) {
        this.arena1 = arena1;
    }

    public boolean isFimdogame() {
        return fimdogame;
    }

    public void setFimdogame(boolean fimdogame) {
        this.fimdogame = fimdogame;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }
    public void atualizacion(){
        System.out.println("Atualizando...");
        if(!fimdogame){
            if(direcao!=direcao_naum){
                celula proxcelula
                        = getproxcelula(cobra.getCabecinha());
                if(cobra.Batebate(proxcelula)){
                    setDirecao(direcao_naum);
                    fimdogame=true;
                }
                else{
                    cobra.mover(proxcelula);
                    if(proxcelula.getCelltype()==celulaType.FOOD){
                        cobra.crescer();
                        arena1.geracaodecomida();
                    }
                }
            }
        }
    }
    private celula getproxcelula(celula posicaoatual){
        System.out.println("achando a próxima celula");
        int linha= posicaoatual.getLinha();
        int coluna= posicaoatual.getColuna();
        if(direcao==direcao_direita){
            coluna++;
        }
        else if(direcao==direcao_esquerda){
            coluna--;
        }
        else if(direcao==direcao_cima){
            linha--;
        }
        else if(direcao==direcao_baixo){
            linha++;
        }
        celula proxcelula = arena1.getCelulas()[linha][coluna];
        return proxcelula;
    }
    public static void main(String[] args){
        Scanner Controle = new Scanner(System.in);
        System.out.println("começando o jogo");
        celula initPos = new celula(0,0);
        Cobra initCobra= new Cobra(initPos);
        arena arena1 = new arena(10,10);
        Jogo newJogo = new Jogo(initCobra,arena1);
        newJogo.fimdogame = false;
        newJogo.direcao = direcao_direita;
        for(int i=0;i<10000000;i++){

            if(i%2==0){
                newJogo.arena1.geracaodecomida();
                newJogo.atualizacion();
            }
            String controle = Controle.nextLine();
            if(Objects.equals(controle, "cima"))
                newJogo.direcao = direcao_cima;
            else if(Objects.equals(controle, "direita"))
                newJogo.direcao = direcao_direita;
            else if(Objects.equals(controle, "esquerda"))
                newJogo.direcao = direcao_esquerda;
            else if(Objects.equals(controle, "baixo"))
                newJogo.direcao = direcao_baixo;

            if(newJogo.fimdogame)
                break;
        }
    }
}
