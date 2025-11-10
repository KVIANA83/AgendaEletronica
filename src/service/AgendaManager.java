/* 
 *  Equipe: 

   - José Paulo Cauás Tenório 
   - Juliana Dias da Silva 
   - Karine Viana Caldas da Silva 
   - Petrus Oliveira de Andrade Cruz 
   - Thiago Nicolas Ananias da Silva
 */

package service;

import java.io.*;
import java.util.*;
import model.Contato;
import exception.ContatoExistenteException;
import exception.ContatoNaoEncontradoException;

public class AgendaManager implements GerenciadorContatos {
    private List<Contato> contatos;

    public AgendaManager() {
        contatos = new ArrayList<>();
    }

    @Override
    public void adicionarContato(Contato contato) throws ContatoExistenteException {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                throw new ContatoExistenteException("Contato já existente: " + contato.getNome());
            }
        }
        contatos.add(contato);
    }

    @Override
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado: " + nome);
    }

    @Override
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        Contato contato = buscarContato(nome);
        contatos.remove(contato);
    }

    @Override
    public List<Contato> listarTodosContatos() {
        return new ArrayList<>(contatos);
    }

    @Override
    public List<Contato> listarContatosOrdenados() {
        List<Contato> ordenados = new ArrayList<>(contatos);
        ordenados.sort(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));
        return ordenados;
    }

    @Override
    public List<Contato> buscarPorDominioEmail(String dominio) {
        List<Contato> resultado = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getEmail().toLowerCase().endsWith(dominio.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @Override
    public void salvarContatosCSV(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Contato c : contatos) {
                writer.write(c.getNome() + ";" + c.getTelefone() + ";" + c.getEmail());
                writer.newLine();
            }
            System.out.println("Contatos salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    @Override
    public void carregarContatosCSV(String nomeArquivo) {
        contatos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    contatos.add(new Contato(partes[0], partes[1], partes[2]));
                }
            }
            System.out.println("Contatos carregados de " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }
}

