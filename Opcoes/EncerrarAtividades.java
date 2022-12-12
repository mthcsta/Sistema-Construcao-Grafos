package Opcoes;

import java.util.concurrent.atomic.AtomicBoolean;

public class EncerrarAtividades implements Opcao {
    private String titulo = "Encerrar Atividades";
    private AtomicBoolean emExecucao;

    public EncerrarAtividades(AtomicBoolean emExecucao) {
        this.emExecucao = emExecucao;
    }

    public void Executar() {
        this.emExecucao.set(false);
    }

    public String getTitulo() {
        return titulo;
    }
}
