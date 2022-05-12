package Functions;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

public class Upper extends GenericUDF {
    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        return null;
    }

    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        String inputString = deferredObjects[0].get().toString();
        if (inputString == null) {
            return "";
        } else {
            String firstLetter = String.valueOf(inputString.charAt(0)).toUpperCase();
            return firstLetter.concat(inputString.substring(1));
        }
    }

    @Override
    public String getDisplayString(String[] strings) {
        return null;
    }
}
