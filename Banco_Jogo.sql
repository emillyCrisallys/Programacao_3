-- Criação do banco de dados
create DATABASE IF NOT EXISTS game_Casa_Abandonada;

-- Seleciona o banco de dados
USE game_Casa_Abandonada;

CREATE TABLE IF NOT EXISTS Scenes (
    id_scenes INT AUTO_INCREMENT PRIMARY KEY,
    scene_name VARCHAR(100) NOT NULL,
    scene_description TEXT NOT null
    
);


-- Tabela para armazenar informações dos jogadores
CREATE TABLE IF NOT EXISTS Player_Save (
    player_id INT AUTO_INCREMENT PRIMARY KEY,
    current_Cena INT NOT NULL,
    FOREIGN KEY (current_Cena) REFERENCES Scenes(id_scenes)
);



-- Tabela para armazenar itens
CREATE TABLE IF NOT EXISTS Scene_Items (
	
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    item_description TEXT NOT NULL,
    is_collectible BOOLEAN NOT null,
    item_scene_id INT NOT NULL,
    efeito_uso VARCHAR(255) NOT null,
    mensagem_uso VARCHAR(255)NOT null,
    FOREIGN KEY (item_scene_id) REFERENCES Scenes(id_scenes)
);



-- Tabela para armazenar o inventário dos jogadores
CREATE TABLE IF NOT EXISTS Inventory (
    player_id INT NOT NULL,
    item_id INT NOT null ,
    item_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (player_id, item_id),
    FOREIGN KEY (player_id) REFERENCES Player_Save(player_id),
    FOREIGN KEY (item_id) REFERENCES Scene_Items(item_id)
);

insert into scenes (id_scenes,scene_name,scene_description)values
('1','A Entrada','Você está parado diante de uma casa abandonada. A  está entreaberta, e uma CHAVE velha e enferrujada está jogada no chão, refletindo a pouca luz do ambiente.'	),
('2','O Saguão','O saguão é amplo e empoeirado. No centro, uma escada de madeira que leva ao andar superior. No canto, você vê uma VELA ainda funcional em um candelabro velho.'),
('3','O Corredor','Você está em um corredor estreito com várias portas fechadas. No chão, há um MAPA sujo e rasgado.'),
('4','O Quarto Escuro','Um quarto escuro e empoeirado. Você mal consegue enxergar, mas percebe um INTERRUPTOR na parede.'),
('5','O Banheiro','Você entra em um banheiro deteriorado. A pia está quebrada, e um MEDALHÃO reluzente jaz no chão. Dentro da pia estava escrito "A verdade está oculta no sótão."'),
('6','A Biblioteca','Você entra em uma biblioteca cheia de LIVROS empoeirados. Uma gaveta fechada atrai sua atenção.(busque algo no seu inventario para abrir a gaveta)'),
('7','A gaveta','Você destrancou a gaveta usando a senha do livro e acabou achando a CHAVE DO SÓTÃO'),
('8','O Sótão','O sótão está cheio de poeira e objetos antigos. Você vê uma arca trancada no canto da sala.(Use um item para abrir a arca)'),
('9','A Arca','Ao abrir a arca, você vê um objeto brilhante dentro, ao terminar de abrir percebeu que é uma ADAGA'),
('10','O Porão','O porão é úmido e mal iluminado. Um corpo está jogado no chão, e uma porta de ferro bloqueia o caminho.(Usar item para abrir a porta)'),
('11','O Laboratório Secreto','Você entra em um laboratório escondido, repleto de MÁQUINAS antigos e um pote misterioso.'),
('12','A Saída','A passagem secreta leva até uma sala com uma saída bloqueada por vigas de madeira. Ao lado, há um PÉ-DE-CABRA.'),
('13','Final Feliz','Você escapou da casa com segurança, mas o mistério dos objetos estranhos ainda paira no ar...'),
('14','Triste Fim', 'Você ficou preso na casa do segurança')

insert into scene_items (item_id,item_name,item_description,is_collectible,item_scene_id,efeito_uso,mensagem_uso) values

/*('1','CHAVE','Uma chave pequena e enferrujada, provavelmente da porta da casa','1','1','USAR','A chave destranca a porta e você entra na casa.'),
*/('2','VELA','Uma vela antiga, mas que pode ser acesa para iluminar seu caminho','1','2','USAR','A vela acende e ilumina o caminho. Você decide subir a escada.'),
('3','MAPA','Uma porta antiga e assustadora','1','3','MUDAR','Você pega o mapa'),
('4','INTERRUPTOR','Um interruptor de luz enferrujado, mas parece que ainda funciona','0','4','USAR','A luz acende, revelando um espelho empoeirado.'),
('5','MEDALHÃO','Um medalhão de ouro com um símbolo misterioso gravado.','1','5','MUDAR','Você pega o medalhão.'),
('6','LIVROS','Um livro antigo e volumoso, parece ter uma senha escrita na última página.','1','6','USAR','Você decide pegar o livro.'),
('7','CHAVE DO SÓTÃO','Uma chave antiga que abre o sótão','1','7','MUDAR','Você pegou a chave do sótão'),
('8','CHAVE DO SÓTÃO','Uma chave antiga que abre a Arca','0','6','USAR','A arca abre'),
('9','ADAGA','Uma faca pequena','1','9','MUDA','Você decide pegar a adaga.'),
('10','ADAGA','Uma faca pequena','0','10','USAR','Você abre a porta de ferro.'),

('11','MÁQUINAS','Um dispositivo antigo que parece ativado por um artefato','0','11','USAR','A máquina ativa e uma passagem secreta se abre.'),
('12','PÉ-DE-CABRA','Uma ferramenta enferrujada, perfeita para remover as vigas.','1','12','USAR','Você remove as vigas e finalmente escapa da casa.')



       
 
select * from scene_items si

select * from scenes s 

select * from inventory i 

SELECT * FROM player_save WHERE player_id = ?;