class Gcd {
  public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);

	if (a == 0 && b == 0)
		b = 1;
	else if (b == 0)
		b = a;
	else if (a != 0)
		while (a != b)
			if ( a < b)
				b -= a;
			else
				a -= b;
	System.out.println("Greatest common divisor " + b);
  }
}
