package pl.ufs.myjava.learning;

public class CreateSubtraction implements CreateEquation {
    private Integer first = 0;
    private Integer second = 0;
    private Integer maxNumber = 10;

    public CreateSubtraction(Integer maxNumber) {
        this.maxNumber = maxNumber;
        createNext();
    }

    @Override
    public Integer getResult() {
        return first - second;
    }

    @Override
    public String getEquation() {
        return first + " - " + second;
    }

    @Override
    public boolean checkResult(Integer result) {
        return getResult().equals(result);
    }

    @Override
    public void createNext() {
        first = (int) (Math.random() * maxNumber);
        second = (int) (Math.random() * first);
    }
}
