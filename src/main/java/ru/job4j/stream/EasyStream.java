package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> first;

    public static EasyStream of(List<Integer> source) {
        return new StreamBuilder().list(source).build();

    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer integer : this.first) {
            rsl.add(fun.apply(integer));
        }
        return new StreamBuilder().list(rsl).build();
    }

        public EasyStream filter(Predicate<Integer> fun) {
            List<Integer> rsl = new ArrayList<>();
            for (Integer integer : this.first) {
                if (fun.test(integer)) {
                    rsl.add(integer);
                }
            }
                return new StreamBuilder().list(rsl).build();
            }

        public List<Integer> collect() {
                return this.first;
        }


    public static class StreamBuilder {
        private EasyStream hardStream;

        public StreamBuilder() {

            hardStream = new EasyStream();
        }

        public StreamBuilder list(List<Integer> first) {
            hardStream.first = first;
            return this;
        }

        public EasyStream build() {
            return hardStream;
        }
    }
}
