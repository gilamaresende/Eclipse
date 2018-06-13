package entrada;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import objetos.Continente;
import objetos.Pais;

public class ArquivosPais {
		//entrada de informaçoes
		Scanner in;
		
		//arquivo de onde sera linda as infomaçoes
		FileReader arq;
		
		//construtor
		public ArquivosPais() {
			
		}
		
		//preparar para leitura
		public void ler(ArrayList<Pais> listaP, ArrayList<Continente> listaC)throws FileNotFoundException{
			
			//instanciar paises
			criarPaises(listaP, listaC);
			
			//definir vizinhos
			ligarVizinhos(listaP);
			
		}
		
		//cria objetos paises
		public void criarPaises(ArrayList<Pais> listaP, ArrayList<Continente> listaC) throws FileNotFoundException {
			//////////////////////////////////////////////////////////////////////////
			//variaveis da função
			/////////////////////////////////////////////////////////////////////////
			
			//controla para ler os paises entre os continetes no arquivo
			int i;
			
			//abre o arquivo com os paises que vao ser criados
			arq = new FileReader("dadosPais.txt");
			
			//modo de entrada das informaçoes dos paises sera por arquivo
			in = new Scanner(arq);
			
			//String qual vai ler cada linha do arquivo
			String linha;
			
			//variavel que estara alocando memoria para criar os paises
			Pais tmpP;
			
			//variavel que estara alocando memoria para criar os continente
			Continente tmpC;
			
			///////////////////////////////////////////////////////////////////////////
			//funcionamento
			///////////////////////////////////////////////////////////////////////////

			//ira rodar enqaunto existir paises para ser criado
			while (in.hasNextLine()) {
				
				//ler continete
				linha = in.nextLine();
				
				//alocar memoria de novo continente
				tmpC = new Continente();
				
				tmpC.setNome(linha);
				//ler paises
				
				//colocar i = 0 para ler 4 paises
				i = 0;
				while(i < 4) {
				
					
					//ler linha com o nome do pais
					linha = in.nextLine();
					
					//aloca memoria para novo pais
					tmpP = new Pais(linha);
					
					
					//adiciona pais na na lista de paises criados
					listaP.add(tmpP);
					
					//adiciona pais na lista de paises do continente
					tmpC.addPaisNoContinente(tmpP);
					
					//inclementa pais lido
					i++;

				}
				//adicionar continente na lista de continente
				listaC.add(tmpC);

			}
		}
		
		public void ligarVizinhos(ArrayList<Pais> paises) throws FileNotFoundException {
			/////////////////////////////////////////////////////////////////////////
			// variaveis da função
			/////////////////////////////////////////////////////////////////////////
			
			//abre o arquivo que informa quem sao os vizinhos
			arq = new FileReader("ligarVizinhos.txt");
			
			//modo de entrada por arquivo
			in = new Scanner(arq);
			
			//vetor que tera os vizinhos em string
			String[] linhaVetor;
			
			//guarda linha do arquivo que vai estar senho lida
			String linha;
			
			//busca qual pais vai ser vizinho
			int procurado;
			
			/////////////////////////////////////////////////////////////////////////
			//comportamento da função
			////////////////////////////////////////////////////////////////////////
			
			//rodar para todas linhas do arquivo
			while(in.hasNextLine()) {
			
				//ler linha atual
				linha = in.nextLine();
		
				//dividi as informaçoes de uma linha e guarda cada uma em uma possicão do vetor de estring
				linhaVetor = linha.split(" ");
				
				
				//as posiçoes 0 e 1 reference a quantidade de informações e a que paises pertencem
				//as demais sao os vizinhos que do pais
				
				//converte para inteiro a quantidade de infomação tem na linha
				int qunt = Integer.parseInt(linhaVetor[0]);
				
				//converte para inteiro qual pais pertence as informaçoes
				int posicacao = Integer.parseInt(linhaVetor[1]);
				
				//verificar as informaçoes na linha
				for (int i = 2 ; i < qunt ; i++) {
					
					//converter para inteiro qual pais sera o vizinho
					procurado = Integer.parseInt(linhaVetor[i]);
					
					//coloca o pais na lista de vizinhos
					paises.get(posicacao).addVizinho(paises.get(procurado));
					
				}
				
			}
		
		}
}
