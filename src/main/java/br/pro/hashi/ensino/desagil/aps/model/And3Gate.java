package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nand;
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;


    public And3Gate() {
        super("AND3", 4);

        nand = new NandGate();
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
    }

    @Override
    public boolean read() {
        return (nand3.read());
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 2) {
            throw new IndexOutOfBoundsException(inputIndex);
        }

        if (inputIndex == 0) {
            nand.connect(0, emitter);
        }

        if (inputIndex == 1) {
            nand.connect(1, emitter);
        }

        if (inputIndex == 2) {
            nand2.connect(1, emitter);
        }

        nand1.connect(0, nand);
        nand1.connect(1, nand);

        nand2.connect(0, nand1);


        nand3.connect(0, nand2);
        nand3.connect(1, nand2);
    }
}

