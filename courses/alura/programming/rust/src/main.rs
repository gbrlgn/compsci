// Substitui ocorrências e não aloca um endereço.
const PI: f32 = 3.14;

// Cria um endereço sem alocar na memória.
static /* pode ser */ mut GLOBAL: u8 = 1;

// Declaração de uma função com parâmetros e seu retorno.
fn soma(a: i32, b: i32) -> i32 {
    // ! indica um macro, e não uma função.
    println!("{} + {} = {}", a, b, a + b);
    // Ausência do ; indica que o valor da expressão deve ser retornado.
    a + b
    // Há também o return.
}

fn escopo() {
    println!("Pi = {}", PI);

    // Inseguro, pois é uma variável global mutável.
    unsafe {
        println!("Variável global = {}", GLOBAL);
    }

    let variavel: i32 = 300;
    // Re-declarações são permitidas, pois alocam outro espaço de memória.
    let variavel: i32 = 301;
    println!("Variável = {}, tamanho = {} bytes", variavel, std::mem::size_of_val(&variavel));

    let decimal: f32 = 2.5;
    println!("Decimal = {}", decimal);

    let mut booleano:bool = false;
    booleano = true;
    println!("Tamanho de um booleano: {}", std::mem::size_of_val(&booleano));

    let letra: char = 'c';
    println!("Tamanho de um char: {}", std::mem::size_of_val(&letra));
}

fn shadowing() {
    let a = 123;
    let b = 444;

    {
        // Não re-declara, mas declara dentro do novo escopo.
        let a = 321;
        println!("a - dentro: ", a);

        // Só é acessada neste escopo.
        let b = 555;
        println!("b - dentro: ", b);
    }

    println!("a - fora: ", a);
    println!("b - fora: ", b);
}

fn condicionais() {
    let idade: u8 = 24;
    let responsavel_autorizou = true;

    if idade >= 18 {
        println!("Pode entrar na balada");
    } else if idade > 16 && responsavel_autorizou {
        println!("Pode entrar com a assinatura do responsável");
    } else {
        println!("Não pode entrar na balada");
    }

    let e_maior = idade >= 18;

    let condicao = if e_maior { "maior" } else { "menor" };

    println!("É {} de idade", condicao);

    let linguagem = "Python";
    let proposito = match linguagem {
        "PHP" => "Web",
        "Kotlin" => "Android",
        "Python" => "Data science",
        // Valor default, ignorado.
        _ => "Desconhecido" 
    };

    println!("O propósito de {} é {}", linguagem, proposito);

    // O propósito de Python é Data science
}

fn repeticoes() {
    let multiplicador = 5;
    let mut contador: u8 = 0;

    while contador < 10 {
        contador += 1
        println!("{} * {} = {}", multiplicador, contador, multiplicador * contador);
    }

    loop {
        contador += 1;
        println!("{} * {} = {}", multiplicador, contador, multiplicador * contador);
        if contador == 10 { break; }

    }

    loop {
        contador += 1;
        if contador == 5 { continue; }
        println!("{} * {} = {}", multiplicador, contador, multiplicador * contador);
    }

    // Como o intervalo é exclusivo, o operador = inclui o limite do intervalo.
    for i in 1..=10 {
        println!("{} * {} = {}", multiplicador, i, multiplicador * i);
    }
}

fn ownership() {
    // Dono da String alocada na Heap.
    let mut uma_string = String::from("Gabriel");
    // O valor é movido para outro dono, pois saiu do escopo.
    // let outra_string = rouba(uma_string);
    // A variável outra_string recebe um ponteiro para o valor roubado.

    // error: borrow of moved value:
    // println!("{}", uma_string);
    // Pois String não implementa Copy.

    // Imprime o valor retornado.
    // println!("{}", outra_string);

    // Passando-se uma referência, o valor é emprestado.
    // rouba(&uma_string);

    // Para poder ser modificado, o valor deve ser mutável e emprestado como mutável.
    rouba(&mut uma_string);

    println!("Emprestado: {}", uma_string);
}

// A variável string é a nova dona.
fn rouba(string: &mut String) {
    // Quando emprestada por &, o valor não é roubado.

    // Resulta em erro, pois a string não é mutável.
    // string = String::from("Gian");

    // Seria permitido, pois não redefine a referência. 
    //Porém, se o valor foi emprestado sem &mut, ele não pode ser modificado,
    // pois a referência deve mutável. com &mut, assim como o valor original.
    string.push_str(" Gian");

    println!("Roubado: {}", string);

    // Retorna um ponteiro para o valor roubado.
    // string
}

fn pattern_matching() {
    for x in 1..=20 {
        println!("{}: {}", x, match x {
            1 => "Pouco",
            2 | 3 => "Pouquinho",
            4..=10 => "Um bocado",
            _ if x % 2 == 0 => "Uma boa quantidade",
            _ => "Muito"
        });
    }

    // Exemplo de pattern matching para pontos cartesianos.
    // match point {
    //     (0, 0) => "Origem",
    //     (0, _) => "Eixo X",
    //     (_, 0) => "Eixo Y",
    //     _ => "?"
    // }
}

fn erros() {
    // Erro ao acessar índice inexistente.
    // let v = vec![1, 2, 3];
    // println!("{}", v[4]);

    // Macro que exibe uma mensagem de erro.
    // panic!("Erro proposital");

    // Executar o código (mesmo compilado) com
    // RUST_BACKTRACE=1 mostra um backtrace do erro.

    // Tratamento de erros com um match.
    match resultado() {
        Ok(s) => println!("String de sucesso: {}", s),
        // Pode ser lançado um panic!, em caso de um erro fatal.
        Err(u) => println!("Número de erro: {}", u)
    };
}

fn resultado -> Result<String, u8> {
    // Este Result retorna uma String em caso de sucesso
    // e um inteiro u8 em caso de erro.

    // Retorno em caso de sucesso.
    Ok(String::from("Tudo deu certo"))

    // Retorno em caso de erro.
    // Err(666)
}

fn main() {
    println!("5 + 6 = {}", soma(5, 6));

    escopo();
    shadowing();
    condicionais();
    repeticoes();
    // Strings são uma referência a um tipo estático.
    // let string:&static str = "string";
    ownership();
    pattern_matching();
    erros();
}