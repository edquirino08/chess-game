package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1)
			throw new BoardException("Erro criando o tabuleiro! Deve haver pelo menos 1 linha e 1 coluna");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row,column)){
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];

	}

	public Piece piece(Position position) {
		if(!positionExists(position)){
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColoumn()];
	}

	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColoumn()] = piece;
		piece.position = position;
	

	}

	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;

	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColoumn());

	}

	public boolean thereIsAPiece(Position position) {
		return piece(position) != null;
	}
}
