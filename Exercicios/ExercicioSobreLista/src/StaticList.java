
public class StaticList<E> implements List<E> {
	
	protected E[] elements;
	int numElements;
	

	public StaticList(int maxSize) {
	    elements = (E[])new Object[maxSize];
	    numElements = 0;
	}

	public int numElements() {
	    return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}
	
	public boolean isFull() {
		return numElements == elements.length;
	}

	@Override
	public void insert(Object element, int pos) {
		// verifica se h� espa�o na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posi��o � v�lida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
			
		// desloca para a direita os elementos necess�rios,
		// abrindo espa�o para o novo elemento
			for (int i = numElements-1; i >= pos; i--)
				elements[i+1] = elements[i];
			
		// armazena o novo elemento e ajusta o total
		elements[pos] = (E) element;
		numElements++;

		
	}

	@Override
	public E remove(int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
			
	// guarda uma refer�ncia tempor�ria ao elemento removido
		E element = elements[pos];
			
	// desloca para a esquerda os elementos necess�rios,
	// sobrescrevendo a posi��o que est� sendo removida
		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];
			
	// define para null a posi��o antes ocupada pelo �ltimo,
	// para que a coleta de lixo possa atuar, e ajusta o total
			elements[numElements-1] = null;
			numElements--;
			return element;

	}

	@Override
	public E get(int pos) {
		// verifica se a posi��o � v�lida
	  	if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
	  	return elements[pos];


	}

	@Override
	public int search(Object element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		
		return -1;

	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}

}
