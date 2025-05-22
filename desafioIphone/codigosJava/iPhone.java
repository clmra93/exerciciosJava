public class iPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    private String musicaAtual;
    private String numeroChamada;
    private String paginaAtual;

    // Reprodutor Musical
    @Override
    public void tocar() {
        if (musicaAtual != null && !musicaAtual.isEmpty()) {
            System.out.println("▶️ Tocando música: " + musicaAtual);
        } else {
            System.out.println("🎶 Nenhuma música selecionada para tocar.");
        }
    }

    @Override
    public void pausar() {
        if (musicaAtual != null && !musicaAtual.isEmpty()) {
            System.out.println("⏸️ Música '" + musicaAtual + "' pausada.");
        } else {
            System.out.println("🎶 Nenhuma música tocando para pausar.");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musicaAtual = musica;
        System.out.println("🎶 Música selecionada: " + musica);
    }

    // Aparelho Telefônico
    @Override
    public void ligar(String numero) {
        this.numeroChamada = numero;
        System.out.println("📞 Ligando para: " + numero + "...");
        // Simulação de chamada em progresso
        System.out.println("📞 Chamada para " + numero + " em andamento.");
    }

    @Override
    public void atender() {
        if (numeroChamada != null && !numeroChamada.isEmpty()) {
            System.out.println("📱✅ Chamada de " + numeroChamada + " atendida.");
            this.numeroChamada = null; // Limpa o número após atender
        } else {
            System.out.println("📱 Nenhuma chamada para atender.");
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("🗣️ Iniciando correio de voz...");
        // Simulação de gravação de mensagem
        System.out.println("🗣️ Deixe sua mensagem após o sinal.");
    }

    // Navegador na Internet
    @Override
    public void exibirPagina(String url) {
        this.paginaAtual = url;
        System.out.println("🌐 Exibindo página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("📑 Nova aba adicionada no navegador.");
    }

    @Override
    public void atualizarPagina() {
        if (paginaAtual != null && !paginaAtual.isEmpty()) {
            System.out.println("🔄 Atualizando página: " + paginaAtual);
            exibirPagina(this.paginaAtual); // Re-exibe a página para simular atualização
        } else {
            System.out.println("🌐 Nenhuma página para atualizar. Exiba uma página primeiro.");
        }
    }

    // Método principal para demonstração (opcional)
    public static void main(String[] args) {
        iPhone meuIphone = new iPhone();

        System.out.println("--- Testando Reprodutor Musical ---");
        meuIphone.selecionarMusica("Stairway to Heaven - Led Zeppelin");
        meuIphone.tocar();
        meuIphone.pausar();
        meuIphone.tocar();

        System.out.println("\n--- Testando Aparelho Telefônico ---");
        meuIphone.ligar("98765-4321");
        // Simular uma chamada recebida para poder atender
        // Em um cenário real, isso seria assíncrono.
        // Para este exemplo, vamos apenas simular que uma chamada está ativa para o método atender.
        // Se não fizermos isso, o 'atender()' dirá que não há chamada.
        // Vamos assumir que a ligação anterior (ligar para "98765-4321") está "chegando"
        System.out.println("... Recebendo chamada de 98765-4321 ...");
        meuIphone.atender(); // Atenderia a chamada simulada acima
        meuIphone.iniciarCorreioVoz();

        System.out.println("\n--- Testando Navegador na Internet ---");
        meuIphone.exibirPagina("https://www.apple.com");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
        meuIphone.exibirPagina("https://www.google.com");
    }
}