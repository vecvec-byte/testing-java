package com.exemplo;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;

public class Main {

    // Interface que representa a DLL, usando JNA
    public interface ImpressoraDLL extends Library {
		
		// Caminho completo para a DLL
    ImpressoraDLL INSTANCE = (ImpressoraDLL) Native.load(
                "/workspaces/testing-java/E1_Impressora01.dll",
                ImpressoraDLL.class
        );
        
	
	    private static String lerArquivoComoString(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        byte[] data = fis.readAllBytes();
        fis.close();
        return new String(data, StandardCharsets.UTF_8);
    }
	
        
        int AbreConexaoImpressora(int tipo, String modelo, String conexao, int param);
        int FechaConexaoImpressora();
        int ImpressaoTexto(String dados, int posicao, int estilo, int tamanho);
        int Corte(int avanco);
        int ImpressaoQRCode(String dados, int tamanho, int nivelCorrecao);
        int ImpressaoCodigoBarras(int tipo, String dados, int altura, int largura, int HRI);
        int AvancaPapel(int linhas);
        int StatusImpressora(int param);
        int AbreGavetaElgin();
        int AbreGaveta(int pino, int ti, int tf);
        int SinalSonoro(int qtd, int tempoInicio, int tempoFim);
        int ModoPagina();
        int LimpaBufferModoPagina();
        int ImprimeModoPagina();
        int ModoPadrao();
        int PosicaoImpressaoHorizontal(int posicao);
        int PosicaoImpressaoVertical(int posicao);
        int ImprimeXMLSAT	(String dados, int param);
        int ImprimeXMLCancelamentoSAT(String dados, String assQRCode, int param);
    }

    private static boolean conexaoAberta = false;
    private static int tipo;
    private static String modelo;
    private static String conexao;
    private static int parametro;
	
    private static final Scanner scanner = new Scanner(System.in);

    private static String capturarEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static void configurarConexao() {
        
    }

    public static void abrirConexao() {
        
    }

    public static void fecharConexao() {
        
    }

    public static String escolherArquivoXML() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("Arquivos XML (*.xml)", "xml");
        fileChooser.setFileFilter(filtroXML);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            return arquivoSelecionado.getAbsolutePath();
        } else {
            throw new Exception("Seleção cancelada pelo usuário.");
        }
    }

    public static void imprimirXML() {
        try {
            String caminho = escolherArquivoXML();
            ImpressoraDLL.INSTANCE.ImprimeXMLSAT(caminho, 0);

        } catch (Exception e) {
                System.out.println(e.getMessage());
        }

      
    }
    public static void imprimirXMLCancel() {
        var assQRCode = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQsE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+ZfO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";
        
        try {
            String caminho = escolherArquivoXML();
            ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(caminho, assQRCode, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(ImpressoraDLL.INSTANCE.AbreConexaoImpressora(1, "i9", "USB", 0));
        while (true) {
            System.out.println("\n*************************************************");
            System.out.println("**************** MENU IMPRESSORA *******************");
            System.out.println("*************************************************\n");

            System.out.println("1  - Configurar Conexao");
            System.out.println("2  - Abrir Conexao");
            System.out.println("3  - Impressao Texto");
            System.out.println("4  - Impressao QRCode");
            System.out.println("5  - Impressao Cod Barras");
            System.out.println("6  - Impressao XML SAT");
            System.out.println("7  - Impressao XML Canc SAT");
            System.out.println("8  - Abrir Gaveta Elgin");
            System.out.println("9  - Abrir Gaveta");
            System.out.println("10 - Sinal Sonoro");
            System.out.println("0  - Fechar Conexao e Sair");
            System.out.println("--------------------------------------");

            String escolha = capturarEntrada("\nDigite a opção desejada: ");

            if (escolha.equals("0")) {
                
            }

            switch (escolha) {
                case "1":
                    
                case "2":
                    
                case "3":
                    
                   
                case "4":
                    
                case "5":
                    
                    
                case "6":
					imprimirXML();

                case "7":
                    imprimirXMLCancel();
                case "8":
                    
                    
                case "9":
                	
                    
                case "10":
                    
                default:
                    
            }
        }

        //scanner.close();
    }


	
}
