package Functions;

import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindOccurrences extends GenericUDF {
    private final IntWritable output = new IntWritable();

    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {
        //If you do not check arguments, it is going to return an error when define in hive
        checkArgsSize(objectInspectors, 0, 1);
        checkArgPrimitive(objectInspectors, 0);
        return PrimitiveObjectInspectorFactory.writableStringObjectInspector;
    }

    protected String getStringValue(DeferredObject[] arguments, int i,
                                    ObjectInspectorConverters.Converter converter) throws HiveException {
        Object obj;
        return (obj = arguments[i].get()) == null ? null : converter.convert(obj).toString();
    }

    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        String inputString = this.getStringValue(deferredObjects, 0, StringConverter::new);
        String wordToCount = this.getStringValue(deferredObjects, 1, StringConverter::new);
        int res = 0;
        if (inputString != null && wordToCount != null) {
            Pattern pattern = Pattern.compile(wordToCount);
            Matcher matcher = pattern.matcher(inputString);
            while (matcher.find()) {
                res += 1;
            }
        }
        output.set(res);
        return output;
    }


    @Override
    public String getDisplayString(String[] strings) {
        return getStandardDisplayString("UPPER", strings, ",");
    }
}
