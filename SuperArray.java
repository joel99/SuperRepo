//Joel Ye
//APCS1 pd10
//HW45 -- Come Together
//2015 - 12 - 09

public class SuperArray{

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    protected Comparable[] _data;

    //position of last meaningful value
    protected int _lastPos;

    //size of this instance of SuperArray
    protected int _size;
	
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new Comparable[10];
	_lastPos = -1;
	_size = 0;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String s = "[";
	for (int i = 0; i < _size; i++){
	    s += _data[i];
	    s += ",";
	}
	if (_size > 0)
	    s = s.substring(0,s.length() - 1);
	s += "]";
	return s;
    }
		
    //double capacity of this SuperArray
    private void expand() { 
	Comparable[] newArr = new Comparable[2 * _data.length];
	for (int i = 0; i < _lastPos; i++)
	    newArr[i] = _data[i];
	_data = newArr;
    }
	
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index];}

    //accessor -- return _data length
    public int get_dataLength() {return _data.length;}
		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }

  // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (_size == _data.length)
		expand();
	_data[_size] = newVal;
	_size +=1;
	_lastPos += 1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (index >= _size)
		throw new IndexOutOfBoundsException();
	if (_size == _data.length)
		expand();
	for (int i = _size; i > index + 1; i--){
	    _data[i] = _data[i - 1];
	}
	_data[index] = newVal;
	_lastPos += 1;
	_size +=1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-emptied slot
    public void remove( int index ) {
	for (int i = index; i < _lastPos; i++)
		_data[i] = _data[i + 1];
	_lastPos -= 1;
	_size -= 1;
	}

    //return number of meaningful items in _data
    public int size() {return _size;}

	public int linSearch(Comparable c){
		for (int i = 0; i < _size; i++)
			if (_data[i].equals(c))
				return i;
		return -1;
	}
	
	public boolean isSorted(){
		for (int i = 0; i < _lastPos; i++)
			if (_data[i].compareTo(_data[i+1]) > 0)
				return false;
		return true;
	}
	
	
    //main method for testing
    public static void main( String[] args ) 
    {
		Rational threeHalves = new Rational(3,2);
		Rational thirty = new Rational(60,2);
		Binary zero = new Binary();
		Binary ten = new Binary(10);
		Hexadecimal eighty = new Hexadecimal("50");
		Hexadecimal tenH = new Hexadecimal(10);
		SuperArray test = new SuperArray();
		test.add(threeHalves);
		test.add(ten);
		test.add(tenH);
		test.add(thirty);
		test.add(eighty);
		System.out.println(test.isSorted());
    }
}
