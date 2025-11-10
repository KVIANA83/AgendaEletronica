package service;

import java.util.List;
import model.Contato;
import exception.ContatoExistenteException;
import exception.ContatoNaoEncontradoException;

public interface GerenciadorContatos {
    void adicionarContato(Contato contato) throws ContatoExistenteException;
    Contato buscarContato(String nome) throws ContatoNaoEncontradoException;
    void removerContato(String nome) throws ContatoNaoEncontradoException;
    List<Contato> listarTodosContatos();
    List<Contato> listarContatosOrdenados();
    List<Contato> buscarPorDominioEmail(String dominio);
    void salvarContatosCSV(String nomeArquivo);
    void carregarContatosCSV(String nomeArquivo);
}
