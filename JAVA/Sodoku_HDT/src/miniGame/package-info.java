package miniGame;
//SODOKU:
//1.	NODE
//-	Attributes
//o	row [1-9]
//o	column [1-9]
//o	zone [1-9]
//o	value [0-9]
//o	reserved: Boolean
//	true: không cho phép thay đổi.
//	false: cho phép người chơi thay đổi.
//o	etc…
//-	Methods
//o	Constructors, getters, setters
//o	validate_row(GAME, row)
//o	validate_column(GAME, column)
//o	validate_zone(GAME, zone)
//2.	GAME
//-	Attributes:
//o	ArrayList [9][9]: Nodes.
//-	Methods
//static 
//o	readData();
//o	showGame();
//o	validateGame();
//o	Node getElement(int row, int column);
//3.	Chương trình chính
//a.	Game g = new Game();
//b.	G.readData();
//c.	while(){
//r = sc.nextInt();
//
//Node node = g.getElement(r, c);
//node.validate_row …
//node.validate_column …
//node.validate_zone …
//g.validateGame();
//}
