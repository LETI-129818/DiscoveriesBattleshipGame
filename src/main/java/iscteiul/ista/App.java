package iscteiul.ista;

import iscteiul.ista.battleship.Fleet;
import iscteiul.ista.battleship.Tasks;

/**
 * Ponto de entrada da aplicação Battleship.
 * Apresenta o título do jogo e inicia a tarefa de gestão de frotas.
 *
 * @author britoeabreu
 * @author adrianolopes
 * @author miguelgoulao
 */
public class App
{
    /**
     * Inicia a aplicação e executa a tarefa de gestão de frotas.
     *
     * @param args argumentos da linha de comandos, não utilizados
     */
    public static void main( String[] args )
    {

        System.out.printf("\n***  Battleship Game ***\n");

        // Tasks.taskA();
        Tasks.taskB();
        //	Tasks.taskC();
        //	Tasks.taskD();
    }
}
