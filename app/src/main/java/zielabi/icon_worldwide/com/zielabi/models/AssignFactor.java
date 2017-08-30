package zielabi.icon_worldwide.com.zielabi.models;

/**
 * Created by margarita on 23/08/2017.
 */

public class AssignFactor
{
    private int mNoWritten;
    private int mNoWrittenOral;
    private int mNoAllWritten;
    private int mNoOral;
    private int mNoAny;


    public AssignFactor(int noWritten, int noWrittenOral, int noAllWritten, int noOral, int noAny) {
        mNoWritten = noWritten;
        mNoWrittenOral = noWrittenOral;
        mNoAllWritten = noAllWritten;
        mNoOral = noOral;
        mNoAny = noAny;
    }


    public int getNoWritten() {
        return mNoWritten;
    }

    public void setNoWritten(int noWritten) {
        mNoWritten = noWritten;
    }

    public int getNoWrittenOral() {
        return mNoWrittenOral;
    }

    public void setNoWrittenOral(int noWrittenOral) {
        mNoWrittenOral = noWrittenOral;
    }

    public int getNoAllWritten() {
        return mNoAllWritten;
    }

    public void setNoAllWritten(int noAllWritten) {
        mNoAllWritten = noAllWritten;
    }

    public int getNoOral() {
        return mNoOral;
    }

    public void setNoOral(int noOral) {
        mNoOral = noOral;
    }

    public int getNoAny() {
        return mNoAny;
    }

    public void setNoAny(int noAny) {
        mNoAny = noAny;
    }
}
