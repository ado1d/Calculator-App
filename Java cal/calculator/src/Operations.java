public class Operations {
    private Display display;

    public Operations(Display display) {
        this.display = display;
    }

    public void evaluate() {
        String expression = display.getComponent().getText();
        try {
            double result = evaluateExp(expression);
            display.getComponent().setText(String.valueOf(result));
        } catch (ArithmeticException e) {
            display.getComponent().setText("Error");
        }
    }

    
    private double evaluateExp (String exp) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < exp.length()) ? exp.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseexp();
                if (pos < exp.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseexp() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('x')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseexp();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(exp.substring(startPos, this.pos));
                } else throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }
        }.parse();
    }
}
