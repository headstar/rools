package com.headstartech.rools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.headstartech.rools.contexts.MapContext;
import com.headstartech.rools.factory.AndOperatorPredicateFactory;
import com.headstartech.rools.factory.BooleanValueFactory;
import com.headstartech.rools.factory.CompositeValueFactory;
import com.headstartech.rools.factory.ContextValueFactory;
import com.headstartech.rools.factory.EqualsPredicateFactory;
import com.headstartech.rools.factory.GreaterThanPredicateFactory;
import com.headstartech.rools.factory.InOperatorPredicateFactory;
import com.headstartech.rools.factory.LessThanPredicateFactory;
import com.headstartech.rools.factory.LongValueFactory;
import com.headstartech.rools.factory.MapPredicateFactory;
import com.headstartech.rools.factory.NotOperatorPredicateFactory;
import com.headstartech.rools.factory.OperatorPredicateFactory;
import com.headstartech.rools.factory.OrOperatorPredicateFactory;
import com.headstartech.rools.factory.StringValueFactory;
import com.headstartech.rools.factory.ValueFactory;
import com.headstartech.rools.functions.DayOfMonthFunction;
import com.headstartech.rools.predicates.AndPredicate;
import com.headstartech.rools.predicates.BooleanComparator;
import com.headstartech.rools.predicates.EqualsComparator;
import com.headstartech.rools.predicates.EqualsPredicate;
import com.headstartech.rools.predicates.LessThanComparator;
import com.headstartech.rools.predicates.LessThanPredicate;
import com.headstartech.rools.predicates.LongComparator;
import com.headstartech.rools.predicates.NotPredicate;
import com.headstartech.rools.predicates.OffsetDateTimeComparator;
import com.headstartech.rools.predicates.StringComparator;
import com.headstartech.rools.values.BooleanLiteralValue;
import com.headstartech.rools.values.ContextValue;
import com.headstartech.rools.values.LongLiteralValue;
import com.headstartech.rools.values.OffsetDateTimeLiteralValue;
import com.headstartech.rools.values.StringLiteralValue;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        LongComparator longComparator = new LongComparator();
        StringComparator stringComparator = new StringComparator();
        OffsetDateTimeComparator offsetDateTimeComparator = new OffsetDateTimeComparator();
        BooleanComparator booleanComparator = new BooleanComparator();

        Collection<LessThanComparator> lessThanComparators = Arrays.asList(longComparator, stringComparator, offsetDateTimeComparator);
        Collection<EqualsComparator> equalsComparators = Arrays.asList(booleanComparator, longComparator, stringComparator, offsetDateTimeComparator);

        OffsetDateTime d1 = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        Value v1 = new OffsetDateTimeLiteralValue(d1);
        Value v2 = new OffsetDateTimeLiteralValue(OffsetDateTime.parse("2017-12-23T10:15:30+01:00"));

        Predicate p1 = new EqualsPredicate(equalsComparators, new LongLiteralValue(3), new DayOfMonthFunction(new ContextValue("date")));
        Predicate p2 = new LessThanPredicate(lessThanComparators, new StringLiteralValue("abc"), new StringLiteralValue("def"));
        Predicate p3 = new EqualsPredicate(equalsComparators, new ContextValue("fruit"), new StringLiteralValue("apple"));
        Predicate p4 = new LessThanPredicate(lessThanComparators, v1, v2);
        Predicate p5 = new NotPredicate(new EqualsPredicate(equalsComparators, new ContextValue("flag"), new BooleanLiteralValue(true)));

        Predicate root = new AndPredicate(Arrays.asList(p1, p2, p3, p4, p5));

        Map<String, Value> values = new HashMap<>();
        values.put("fruit", new StringLiteralValue("apple"));
        values.put("date", new OffsetDateTimeLiteralValue(d1));
        values.put("flag", new BooleanLiteralValue(false));

        Context context = new MapContext(values);
        System.out.println(root.evaluate(context));
    }

    @org.junit.jupiter.api.Test
    public void predicateTest() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String doc = "{\n" +
                "  \"and\": [\n" +
                "    {\n" +
                "      \"eq\": {\n" +
                "        \"a\": \"${name}\",\n" +
                "        \"b\": \"john\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"gt\": {\n" +
                "        \"a\": \"${length}\",\n" +
                "        \"b\": \"190\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"not\" : {\n" +
                "        \"lt\": {\n" +
                "          \"a\": 150,\n" +
                "          \"b\": 190\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"in\" : {\n" +
                "        \"elem\" : \"apple\",\n" +
                "        \"coll\" : [\"banana\", \"pear\"]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
        Map<String, Object> map = om.readValue(doc, typeRef);

        LongComparator longComparator = new LongComparator();
        StringComparator stringComparator = new StringComparator();
        Collection<LessThanComparator> lessThanComparators = Arrays.asList(longComparator, stringComparator);
        Collection<EqualsComparator> equalsComparators = Arrays.asList(longComparator, stringComparator);

        List<ValueFactory> valueFactories = Arrays.asList(
                new BooleanValueFactory(),
                new LongValueFactory(),
                new ContextValueFactory(),
                new StringValueFactory());
        ValueFactory valueFactory = new CompositeValueFactory(valueFactories);

        LessThanPredicateFactory lessThanPredicateFactory = new LessThanPredicateFactory(lessThanComparators,
                valueFactory);
        EqualsPredicateFactory equalsPredicateFactory = new EqualsPredicateFactory(equalsComparators,
                valueFactory);

        Map<String, OperatorPredicateFactory> operatorPredicateFactoryMap = new HashMap<>();
        operatorPredicateFactoryMap.put("and", new AndOperatorPredicateFactory());
        operatorPredicateFactoryMap.put("or", new OrOperatorPredicateFactory());
        operatorPredicateFactoryMap.put("not", new NotOperatorPredicateFactory());

        operatorPredicateFactoryMap.put("lt", lessThanPredicateFactory);
        operatorPredicateFactoryMap.put("eq", equalsPredicateFactory);
        operatorPredicateFactoryMap.put("gt", new GreaterThanPredicateFactory(equalsPredicateFactory, lessThanPredicateFactory, valueFactory));
        operatorPredicateFactoryMap.put("in", new InOperatorPredicateFactory(equalsPredicateFactory, valueFactory));

        MapPredicateFactory mapPredicateFactory = new MapPredicateFactory(operatorPredicateFactoryMap);
        Predicate p = mapPredicateFactory.createPredicate(map);

        Map<String, Value> values = new HashMap<>();
        values.put("name", new StringLiteralValue("john"));
        values.put("length", new StringLiteralValue("200"));

        Context context = new MapContext(values);
        System.out.println(p.evaluate(context));

    }
}
