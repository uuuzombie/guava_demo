package com.sky.demo.qua.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Simulate a simplified grep command in Java.
 * <p>
 * Typically you can use it as follows:
 * </p>
 * <code>
 *     Grep grep = Grep.create()
 *          .recursive(true) // recursively search through the given directory
 *          .pattern(pattern) // and test all the lines against the given pattern
 *          .build();
 *    // then you can grep out all the matched lines
 *    List<String> matchedLines = grep.grep(rootDirectoryOrFile);
 * 
 *    // or providing a callback to process the matched lines
 *    LineProcessor<T> processor = new LineProcessor<T>(){...};
 *    grep.grep(rootDirectoryOrFile, processor);
 *    T value = processor.getResult();
 * </code>
 * 
 * <p>
 * you may find those classes are useful:
 * <ul>
 * <li>{@link com.google.common.io.Files#fileTreeTraverser()}</li>
 * <li>{@link com.google.common.io.CharSource#concat(Iterable)}</li>
 * <li>{@link com.google.common.collect.Iterators#transform(java.util.Iterator, com.google.common.base.Function)}</li>
 * <li>{@link com.google.common.io.Closer}</li>
 * </ul>
 * </p>
 *
 *
 * @author sy
 */
@Exercise(name = "Grep", difficulty = Difficulty.HARD, related = { Files.class, TreeTraverser.class, CharSource.class })
public class Grep {

    private final boolean recursive;

    private final Predicate<File> filePredicate;

    private final Pattern pattern;

    private Grep(Builder builder) {
        this.recursive = builder.recursive;
        this.filePredicate = builder.filePredicate;
        this.pattern = builder.pattern;
    }

    public static Builder create() {
        return new Builder();
    }

    public boolean isRecursive() {
        return recursive;
    }

    public Predicate<File> getFilePredicate() {
        return filePredicate;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public List<String> grep(String fileOrDirectory) {
        // TODO implement this
        return null;
    }

    public void grep(String fileOrDirectory, LineProcessor<?> lineProcessor) {
        // TODO implement this
    }

    public static class Builder {

        /**
         * Recursively search the given directory or not
         */
        private boolean recursive = false;

        /**
         * Predicate to filter the files.
         */
        private Predicate<File> filePredicate = Predicates.alwaysTrue();

        /**
         * Pattern to be matched against. may be {@code null} to indicate matching all lines.
         */
        private Pattern pattern;

        private Builder() {
        }

        public boolean isRecursive() {
            return recursive;
        }

        public Predicate<File> getFilePredicate() {
            return filePredicate;
        }

        public Pattern getPattern() {
            return pattern;
        }

        /**
         * recursively search or not
         */
        public Builder recursive(boolean recursive) {
            this.recursive = recursive;
            return this;
        }

        /**
         * The pattern to search. all the lines can
         */
        public Builder pattern(Pattern pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Specify the Predicate used to filter the files.
         *
         * @param filePredicate the Predicate to be used
         * @throws NullPointerException if the given filePredicate is null
         */
        public Builder filenamePredicate(Predicate<File> filePredicate) {
            Preconditions.checkArgument(this.filePredicate != null, "filePrecondition cannot be null");
            this.filePredicate = filePredicate;
            return this;
        }

        /**
         * build a new Grep using this builder
         */
        public Grep build() {
            return new Grep(this);
        }
    }
}
