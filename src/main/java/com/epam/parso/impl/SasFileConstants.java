/**
 * *************************************************************************
 * Copyright (C) 2015 EPAM
 * <p>
 * This file is part of Parso.
 * <p>
 * This file may be distributed and/or modified under the terms of the
 * GNU General License version 3 as published by the Free Software
 * Foundation and appearing in the file LICENSE.GPL included in the
 * packaging of this file.
 * <p>
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 * *************************************************************************
 */

package com.epam.parso.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is an class to store constants for parsing the sas7bdat file (byte offsets, column formats, accuracy) as well as
 * the standard constants of time and the sizes of standard data types.
 */
interface SasFileConstants {
    /**
     * The size of the long value type in bytes.
     */
    int BYTES_IN_LONG = 8;

    /**
     * The size of the double value type in bytes.
     */
    int BYTES_IN_DOUBLE = 8;

    /**
     * The size of the int value type in bytes.
     */
    int BYTES_IN_INT = 4;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_1_LENGTH} bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ALIGN_1_OFFSET} bytes offset equals to ALIGN_1_CHECKER_VALUE, then starting from
     * the {@link SasFileConstants#DATE_CREATED_OFFSET} bytes offset every offset should increase by
     * {@link SasFileConstants#ALIGN_1_VALUE} bytes.
     */
    int ALIGN_1_CHECKER_VALUE = 51;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_1_LENGTH} bytes stored in the sas7bdat file with
     * a ALIGN_1_OFFSET bytes offset equals to {@link SasFileConstants#ALIGN_1_CHECKER_VALUE}, then starting from
     * the {@link SasFileConstants#DATE_CREATED_OFFSET} bytes offset every offset should increase by
     * {@link SasFileConstants#ALIGN_1_VALUE} bytes.
     */
    long ALIGN_1_OFFSET = 32L;

    /**
     * If a value with the length of ALIGN_1_LENGTH bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ALIGN_1_OFFSET} bytes offset equals to {@link SasFileConstants#ALIGN_1_CHECKER_VALUE},
     * then starting from the {@link SasFileConstants#DATE_CREATED_OFFSET} bytes offset every offset should increase
     * by {@link SasFileConstants#ALIGN_1_VALUE} bytes.
     */
    int ALIGN_1_LENGTH = 1;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_1_LENGTH} bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ALIGN_1_OFFSET} bytes offset equals to {@link SasFileConstants#ALIGN_1_CHECKER_VALUE},
     * then starting from the {@link SasFileConstants#DATE_CREATED_OFFSET} bytes offset every offset should increase by
     * ALIGN_1_VALUE bytes.
     */
    int ALIGN_1_VALUE = 4;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_2_LENGTH} bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ALIGN_2_OFFSET} bytes offset equals to U64_BYTE_CHECKER_VALUE, then:
     * - this sas7bdat file was created in the 64-bit version of SAS,
     * - starting from the {@link SasFileConstants#SAS_RELEASE_OFFSET} bytes offset every offset should increase by
     * {@link SasFileConstants#ALIGN_2_VALUE} bytes (in addition to {@link SasFileConstants#ALIGN_1_VALUE} bytes, if
     * those are added),
     * - the {@link SasFileConstants#PAGE_COUNT_LENGTH} value should increase by {@link SasFileConstants#ALIGN_2_VALUE}
     * bytes and the number of pages stored at the {@link SasFileConstants#PAGE_COUNT_OFFSET} bytes offset should read
     * as long.
     */
    int U64_BYTE_CHECKER_VALUE = 51;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_2_LENGTH} bytes stored in the sas7bdat file with
     * a ALIGN_2_OFFSET bytes offset equals to {@link SasFileConstants#U64_BYTE_CHECKER_VALUE}, then:
     * - this sas7bdat file was created in the 64-bit version of SAS,
     * - starting from the {@link SasFileConstants#SAS_RELEASE_OFFSET} bytes offset every offset should increase
     * by {@link SasFileConstants#ALIGN_2_VALUE} bytes, (in addition to {@link SasFileConstants#ALIGN_1_VALUE}
     * bytes if those are added) and the number of pages stored at the {@link SasFileConstants#PAGE_COUNT_OFFSET} bytes
     * offset should read as long.
     */
    long ALIGN_2_OFFSET = 35L;

    /**
     * If a value with the length of ALIGN_2_LENGTH bytes stored in the sas7bdat file at
     * a {@link SasFileConstants#ALIGN_2_OFFSET} bytes offset equals to
     * {@link SasFileConstants#U64_BYTE_CHECKER_VALUE}, then:
     * - this sas7bdat file was created in the 64-bit version of SAS,
     * - starting from the {@link SasFileConstants#SAS_RELEASE_OFFSET} bytes offset every offset should increase by
     * {@link SasFileConstants#ALIGN_2_VALUE} bytes (in addition to {@link SasFileConstants#ALIGN_1_VALUE} bytes if
     * those are added) and the number of pages stored at the {@link SasFileConstants#PAGE_COUNT_OFFSET} bytes offset
     * should read as long.
     */
    int ALIGN_2_LENGTH = 1;

    /**
     * If a value with the length of {@link SasFileConstants#ALIGN_2_LENGTH} bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ALIGN_2_OFFSET} bytes offset equals to
     * {@link SasFileConstants#U64_BYTE_CHECKER_VALUE}, then:
     * - this sas7bdat file was created in the 64-bit version of SAS,
     * - starting from the {@link SasFileConstants#SAS_RELEASE_OFFSET} bytes offset every offset should increase by
     * ALIGN_2_VALUE bytes (in addition to {@link SasFileConstants#ALIGN_1_VALUE} bytes if those are added) and
     * the number of pages stored at the {@link SasFileConstants#PAGE_COUNT_OFFSET} bytes offset should read as long.
     */
    int ALIGN_2_VALUE = 4;

    /**
     * If a value with the length of {@link SasFileConstants#ENDIANNESS_LENGTH} bytes stored in the sas7bdat file with
     * a ENDIANNESS_OFFSET bytes offset equals to 1 then the bytes order is little-endian (Intel),
     * if the value equals to 0 then the bytes order is big-endian.
     */
    long ENDIANNESS_OFFSET = 37L;

    /**
     * If a value with the length of ENDIANNESS_LENGTH bytes stored in the sas7bdat file with
     * a {@link SasFileConstants#ENDIANNESS_OFFSET} bytes offset equals to 1 then the bytes order is
     * little-endian (Intel), if the value equals to 0 then the bytes order is big-endian.
     */
    int ENDIANNESS_LENGTH = 1;

    /**
     * The sas7bdat file stores the table name with the length of {@link SasFileConstants#DATASET_LENGTH} bytes and
     * a DATASET_OFFSET bytes offset.
     */
    long DATASET_OFFSET = 92L;

    /**
     * The sas7bdat file stores the table name with the length of DATASET_LENGTH bytes and
     * a {@link SasFileConstants#DATASET_OFFSET} bytes offset.
     */
    int DATASET_LENGTH = 64;

    /**
     * The sas7bdat file stores its file type with the length of {@link SasFileConstants#FILE_TYPE_LENGTH} bytes
     * and a FILE_TYPE_OFFSET bytes offset.
     */
    long FILE_TYPE_OFFSET = 156L;

    /**
     * The sas7bdat file stores its file type with the length of FILE_TYPE_LENGTH bytes and
     * a {@link SasFileConstants#FILE_TYPE_OFFSET} bytes offset.
     */
    int FILE_TYPE_LENGTH = 8;

    /**
     * The sas7bdat file stores its creation date with the length of {@link SasFileConstants#DATE_CREATED_LENGTH} bytes
     * and a DATE_CREATED_OFFSET bytes offset (with possible addition of {@link SasFileConstants#ALIGN_1_VALUE}).
     * The date is a double value denoting the number of seconds elapsed from 01/01/1960 to the date stored.
     */
    long DATE_CREATED_OFFSET = 164L;

    /**
     * The sas7bdat file stores its creation date with the length of DATE_CREATED_LENGTH bytes and
     * a {@link SasFileConstants#DATE_CREATED_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE}). The date is a double value denoting the number of seconds elapsed
     * from 01/01/1960 to the date stored.
     */
    int DATE_CREATED_LENGTH = 8;

    /**
     * The sas7bdat file stores its last modification date with the length of
     * {@link SasFileConstants#DATE_MODIFIED_LENGTH} bytes and a DATE_MODIFIED_OFFSET bytes offset (with possible
     * addition of {@link SasFileConstants#ALIGN_1_VALUE}). The date is a double value denoting the number of seconds
     * elapsed from 01/01/1960 to the date stored.
     */
    long DATE_MODIFIED_OFFSET = 172L;

    /**
     * The sas7bdat file stores its last modification date with the length of DATE_MODIFIED_LENGTH bytes and
     * a {@link SasFileConstants#DATE_MODIFIED_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE}). The date is a value of double format denoting the number of seconds
     * elapsed from 01/01/1960 to the date stored.
     */
    int DATE_MODIFIED_LENGTH = 8;

    /**
     * The sas7bdat file stores the length of its metadata (can be 1024 and 8192) as an int value with the length of
     * {@link SasFileConstants#HEADER_SIZE_LENGTH} bytes and a HEADER_SIZE_OFFSET bytes offset (with possible addition
     * of {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    long HEADER_SIZE_OFFSET = 196L;

    /**
     * The sas7bdat file stores the length of its metadata (can be 1024 and 8192) as an int value with the length of
     * HEADER_SIZE_LENGTH bytes and a  {@link SasFileConstants#HEADER_SIZE_OFFSET} bytes offset (with possible addition
     * of {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    int HEADER_SIZE_LENGTH = 4;

    /**
     * The sas7bdat file stores the length of its pages as an int value with the length of
     * {@link SasFileConstants#PAGE_SIZE_LENGTH} bytes and a PAGE_SIZE_OFFSET bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    long PAGE_SIZE_OFFSET = 200L;

    /**
     * The sas7bdat file stores the length of its pages as an int value with the length of PAGE_SIZE_LENGTH bytes and
     * a {@link SasFileConstants#PAGE_SIZE_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    int PAGE_SIZE_LENGTH = 4;

    /**
     * The sas7bdat file stores the number of its pages as an int or long value (depending on
     * {@link SasFileConstants#ALIGN_2_VALUE}) with the length of {@link SasFileConstants#PAGE_COUNT_LENGTH} bytes
     * (with possible addition of {@link SasFileConstants#ALIGN_2_VALUE}) and a PAGE_COUNT_OFFSET bytes offset
     * (with possible addition of {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    long PAGE_COUNT_OFFSET = 204L;

    /**
     * The sas7bdat file stores the number of its pages as an int or long value (depending on
     * {@link SasFileConstants#ALIGN_2_VALUE}) with the length of PAGE_COUNT_LENGTH bytes (with possible addition of
     * {@link SasFileConstants#ALIGN_2_VALUE}) and a {@link SasFileConstants#PAGE_COUNT_OFFSET} bytes offset
     * (with possible addition of {@link SasFileConstants#ALIGN_1_VALUE}).
     */
    int PAGE_COUNT_LENGTH = 4;

    /**
     * The sas7bdat file stores the name of SAS version in which the sas7bdat was created with the length of
     * {@link SasFileConstants#SAS_RELEASE_LENGTH} bytes and a SAS_RELEASE_OFFSET bytes offset (with possible addition
     * of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    long SAS_RELEASE_OFFSET = 216L;

    /**
     * The sas7bdat file stores the name of SAS version in which the sas7bdat was created with the length of
     * SAS_RELEASE_LENGTH bytes and a {@link SasFileConstants#SAS_RELEASE_OFFSET} bytes offset (with possible addition
     * of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int SAS_RELEASE_LENGTH = 8;

    /**
     * The sas7bdat file stores the name of the server version on which the sas7bdat was created with the length of
     * {@link SasFileConstants#SAS_SERVER_TYPE_LENGTH} bytes and a SAS_SERVER_TYPE_OFFSET bytes offset (with possible
     * addition of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    long SAS_SERVER_TYPE_OFFSET = 224L;

    /**
     * The sas7bdat file stores the name of the server version on which the sas7bdat was created with the length of
     * SAS_SERVER_TYPE_LENGTH bytes and a {@link SasFileConstants#SAS_SERVER_TYPE_OFFSET} bytes offset (with possible
     * addition of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int SAS_SERVER_TYPE_LENGTH = 16;

    /**
     * The sas7bdat file stores the version of the OS in which the sas7bdat was created with the length of
     * {@link SasFileConstants#OS_VERSION_NUMBER_LENGTH} bytes and a OS_VERSION_NUMBER_OFFSET bytes offset
     * (with possible addition of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    long OS_VERSION_NUMBER_OFFSET = 240L;

    /**
     * The sas7bdat file stores the version of the OS in which the sas7bdat was created with the length of
     * OS_VERSION_NUMBER_LENGTH bytes and a {@link SasFileConstants#OS_VERSION_NUMBER_OFFSET} bytes offset (with
     * possible addition of {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int OS_VERSION_NUMBER_LENGTH = 16;

    /**
     * The sas7bdat file stores the name of the OS in which the sas7bdat was created with the length of
     * {@link SasFileConstants#OS_MAKER_LENGTH} bytes and a OS_MAKER_OFFSET bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}). If the OS name is
     * an empty string, then the file stores the OS name with the length of {@link SasFileConstants#OS_NAME_LENGTH}
     * bytes and a {@link SasFileConstants#OS_NAME_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    long OS_MAKER_OFFSET = 256L;

    /**
     * The sas7bdat file stores the name of the OS in which the sas7bdat was created with the length of OS_MAKER_LENGTH
     * bytes and a {@link SasFileConstants#OS_MAKER_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}). If the OS name is
     * an empty string, then the file stores the OS name with the length of {@link SasFileConstants#OS_NAME_LENGTH}
     * bytes and a {@link SasFileConstants#OS_NAME_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int OS_MAKER_LENGTH = 16;

    /**
     * The sas7bdat file stores the name of the OS in which the sas7bdat was created with the length of
     * {@link SasFileConstants#OS_NAME_LENGTH} bytes and a OS_NAME_OFFSET bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}). If the OS name is
     * an empty string, then the file stores the OS name with the length of {@link SasFileConstants#OS_MAKER_LENGTH}
     * bytes and a {@link SasFileConstants#OS_MAKER_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    long OS_NAME_OFFSET = 272L;

    /**
     * The sas7bdat file stores the name of the OS in which the sas7bdat was created with the length of OS_NAME_LENGTH
     * bytes and a {@link SasFileConstants#OS_NAME_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}). If the OS name is
     * an empty string, then the file stores the OS name with the length of  {@link SasFileConstants#OS_MAKER_LENGTH}
     * bytes and a {@link SasFileConstants#OS_MAKER_OFFSET} bytes offset (with possible addition of
     * {@link SasFileConstants#ALIGN_1_VALUE} and {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int OS_NAME_LENGTH = 16;

    /**
     * An offset in bytes from the start of the page - for sas7bdat files created in the 32-bit version of SAS
     * (see {@link SasFileConstants#ALIGN_2_VALUE}). Added to all offsets within a page.
     */
    int PAGE_BIT_OFFSET_X86 = 16;

    /**
     * An offset in bytes from the start of the page - for sas7bdat files created in the 64-bit version of SAS
     * (see {@link SasFileConstants#ALIGN_2_VALUE}). Added to all offsets within a page.
     */
    int PAGE_BIT_OFFSET_X64 = 32;

    /**
     * The length in bytes of one subheader pointer ({@link SasFileParser.SubheaderPointer}) of a sas7bdat file
     * created in the 32-bit version of SAS (see {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int SUBHEADER_POINTER_LENGTH_X86 = 12;

    /**
     * The length in bytes of one subheader pointer ({@link SasFileParser.SubheaderPointer}) of a sas7bdat file
     * created in the 64-bit version of SAS (see {@link SasFileConstants#ALIGN_2_VALUE}).
     */
    int SUBHEADER_POINTER_LENGTH_X64 = 24;

    /**
     * The sas7bdat file stores the type of page as a short value with the length of
     * {@link SasFileConstants#PAGE_TYPE_LENGTH} bytes and a PAGE_TYPE_OFFSET bytes offset (with addition of
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     * There can be {@link SasFileConstants#PAGE_META_TYPE}, {@link SasFileConstants#PAGE_DATA_TYPE}, or
     * {@link SasFileConstants#PAGE_MIX_TYPE} page types.
     */
    long PAGE_TYPE_OFFSET = 0L;

    /**
     * The sas7bdat file stores the type of page as a short value with the length of PAGE_TYPE_LENGTH bytes
     * and a {@link SasFileConstants#PAGE_TYPE_OFFSET} bytes offset (with addition of
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     * There can be {@link SasFileConstants#PAGE_META_TYPE}, {@link SasFileConstants#PAGE_DATA_TYPE}, or
     * {@link SasFileConstants#PAGE_MIX_TYPE} page types.
     */
    int PAGE_TYPE_LENGTH = 2;

    /**
     * For pages of the {@link SasFileConstants#PAGE_DATA_TYPE} type, the sas7bdat file stores the number of rows
     * in the table on the current page as a short value - with the length of
     * {@link SasFileConstants#BLOCK_COUNT_LENGTH} bytes and a BLOCK_COUNT_OFFSET bytes offset (with addition of
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     */
    long BLOCK_COUNT_OFFSET = 2L;

    /**
     * For pages of the {@link SasFileConstants#PAGE_DATA_TYPE} type, the sas7bdat file stores the number of rows
     * in the table on the current page as a short value - with the length of BLOCK_COUNT_LENGTH bytes
     * and a {@link SasFileConstants#BLOCK_COUNT_OFFSET} bytes offset (with addition of
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     */
    int BLOCK_COUNT_LENGTH = 2;

    /**
     * For pages of the {@link SasFileConstants#PAGE_META_TYPE} and {@link SasFileConstants#PAGE_MIX_TYPE} types,
     * the sas7bdat file stores the number of subheaders on the current page as a short value - with the length of
     * {@link SasFileConstants#SUBHEADER_COUNT_LENGTH} bytes and a SUBHEADER_COUNT_OFFSET bytes offset from
     * the beginning of the page (with addition of {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     */
    long SUBHEADER_COUNT_OFFSET = 4L;

    /**
     * For pages of the {@link SasFileConstants#PAGE_META_TYPE} and {@link SasFileConstants#PAGE_MIX_TYPE} types,
     * the sas7bdat file stores the number of subheaders on the current page as a short value - with the length of
     * SUBHEADER_COUNT_LENGTH bytes and a {@link SasFileConstants#SUBHEADER_COUNT_OFFSET} bytes offset from
     * the beginning of the page (with addition of {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or
     * {@link SasFileConstants#PAGE_BIT_OFFSET_X64}).
     */
    int SUBHEADER_COUNT_LENGTH = 2;

    /**
     * The page type storing only metadata as a set of subheaders.
     */
    int PAGE_META_TYPE = 0;

    /**
     * The page type storing only data as a number of table rows.
     */
    int PAGE_DATA_TYPE = 256;

    /**
     * The page type storing metadata as a set of subheaders and data as a number of table rows.
     */
    int PAGE_MIX_TYPE = 512;

    /**
     * The sas7bdat file stores the array of subheader pointers ({@link SasFileParser.SubheaderPointer}) at this
     * offset (adding {@link SasFileConstants#PAGE_BIT_OFFSET_X86} or {@link SasFileConstants#PAGE_BIT_OFFSET_X64})
     * from the beginning of the page.
     */
    int SUBHEADER_POINTERS_OFFSET = 8;

    /**
     * If the {@link SasFileParser.SubheaderPointer#compression} value of a subheader equals to TRUNCATED_SUBHEADER_ID
     * then it does not contain useful information.
     */
    int TRUNCATED_SUBHEADER_ID = 1;

    /**
     * A subheader with compressed data has two parameters:
     * its {@link SasFileParser.SubheaderPointer#compression} should equal to COMPRESSED_SUBHEADER_ID and its
     * {@link SasFileParser.SubheaderPointer#type} should equal to {@link SasFileConstants#COMPRESSED_SUBHEADER_TYPE}.
     */
    int COMPRESSED_SUBHEADER_ID = 4;

    /**
     * A Subheader with compressed data has two parameters:
     * its {@link SasFileParser.SubheaderPointer#compression} should equal to
     * {@link SasFileConstants#COMPRESSED_SUBHEADER_ID} and its {@link SasFileParser.SubheaderPointer#type}
     * should equal to COMPRESSED_SUBHEADER_TYPE.
     */
    int COMPRESSED_SUBHEADER_TYPE = 1;

    /**
     * The number of bits in a byte.
     */
    int BITS_IN_BYTE = 8;

    /**
     * The multiplier whose product with the length of the variable type (that can be int or long depending on the
     * {@link SasFileConstants#ALIGN_2_VALUE} value) is the offset from the subheader beginning
     * {@link SasFileParser.RowSizeSubheader} at which the row length is stored.
     */
    int ROW_LENGTH_OFFSET_MULTIPLIER = 5;

    /**
     * The multiplier whose product with the length of the variable type (that can be int or long depending on the
     * {@link SasFileConstants#ALIGN_2_VALUE} value) is the offset from the subheader beginning
     * {@link SasFileParser.RowSizeSubheader} at which the number of rows in the table is stored.
     */
    int ROW_COUNT_OFFSET_MULTIPLIER = 6;

    /**
     * The multiplier whose product with the length of the variable type (that can be int or long depending on the
     * {@link SasFileConstants#ALIGN_2_VALUE} value) is the offset from the subheader beginning
     * {@link SasFileParser.RowSizeSubheader} at which the file stores the number of rows in the table
     * on the last page of the {@link SasFileConstants#PAGE_MIX_TYPE} type.
     */
    int ROW_COUNT_ON_MIX_PAGE_OFFSET_MULTIPLIER = 15;

    /**
     * The number of bytes taken by the value denoting the length of the text block with information about
     * file compression and table rows (name, label, format).
     */
    int TEXT_BLOCK_SIZE_LENGTH = 2;

    /**
     * A substring that appears in the text block with information about file compression and table rows
     * (name, label, format) if CHAR compression is used.
     */
    String COMPRESS_CHAR_IDENTIFYING_STRING = "SASYZCRL";

    /**
     * A substring that appears in the text block with information about file compression and table rows
     * (name, label, format) if BIN compression is used.
     */
    String COMPRESS_BIN_IDENTIFYING_STRING = "SASYZCR2";

    /**
     * The length of the column name pointer in bytes.
     */
    int COLUMN_NAME_POINTER_LENGTH = 8;

    /**
     * For each table column, the sas7bdat file stores the index of the
     * {@link SasFileParser.ColumnTextSubheader} subheader whose text block contains the name
     * of the column - with the length of {@link SasFileConstants#COLUMN_NAME_TEXT_SUBHEADER_LENGTH} bytes and an offset
     * measured from the beginning of the {@link SasFileParser.ColumnNameSubheader} subheader
     * and calculated by the following formula: COLUMN_NAME_TEXT_SUBHEADER_OFFSET +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    long COLUMN_NAME_TEXT_SUBHEADER_OFFSET = 0L;

    /**
     * For each table column, the sas7bdat file stores the index of the
     * {@link SasFileParser.ColumnTextSubheader} subheader whose text block contains the name
     * of the column - with the length of COLUMN_NAME_TEXT_SUBHEADER_LENGTH bytes and an offset measured from
     * the beginning of the {@link SasFileParser.ColumnNameSubheader} subheader
     * and calculated by the following formula: {@link SasFileConstants#COLUMN_NAME_TEXT_SUBHEADER_OFFSET} +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    int COLUMN_NAME_TEXT_SUBHEADER_LENGTH = 2;

    /**
     * For each table column, the sas7bdat file stores the offset (in symbols) of the column name from the beginning
     * of the text block of the {@link SasFileParser.ColumnTextSubheader} subheader (see
     * {@link SasFileConstants#COLUMN_NAME_TEXT_SUBHEADER_OFFSET})- with the length of
     * {@link SasFileConstants#COLUMN_NAME_OFFSET_LENGTH} bytes and an offset measured from the beginning
     * of the {@link SasFileParser.ColumnNameSubheader} subheader and calculated by
     * the following formula: COLUMN_NAME_OFFSET_OFFSET +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    long COLUMN_NAME_OFFSET_OFFSET = 2L;

    /**
     * For each table column, the sas7bdat file stores the offset (in symbols) of the column name from the beginning
     * of the text block of the {@link SasFileParser.ColumnTextSubheader} subheader (see
     * {@link SasFileConstants#COLUMN_NAME_TEXT_SUBHEADER_OFFSET})- with the length of COLUMN_NAME_OFFSET_LENGTH bytes
     * and an offset measured from the beginning of the {@link SasFileParser.ColumnNameSubheader}
     * subheader and calculated by the following formula: {@link SasFileConstants#COLUMN_NAME_OFFSET_OFFSET} +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    int COLUMN_NAME_OFFSET_LENGTH = 2;

    /**
     * For each table column, the sas7bdat file stores column name length (in symbols):
     * - with the length of {@link SasFileConstants#COLUMN_NAME_LENGTH_LENGTH} bytes,
     * - at an offset  measured from the beginning of the
     * {@link SasFileParser.ColumnNameSubheader} subheader
     * and calculated by the following formula: COLUMN_NAME_LENGTH_OFFSET +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    long COLUMN_NAME_LENGTH_OFFSET = 4L;

    /**
     * For each table column, the sas7bdat file stores column name length (in symbols):
     * - with the length of COLUMN_NAME_LENGTH_LENGTH bytes.
     * - at an offset measured from the beginning of the
     * {@link SasFileParser.ColumnNameSubheader} subheader and calculated
     * by the following formula: {@link SasFileConstants#COLUMN_NAME_LENGTH_OFFSET} +
     * + column number * {@link SasFileConstants#COLUMN_NAME_POINTER_LENGTH} + size of the value type (int or long
     * depending on the {@link SasFileConstants#ALIGN_2_VALUE} value).
     */
    int COLUMN_NAME_LENGTH_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the value (int or long depending on
     * {@link SasFileConstants#ALIGN_2_VALUE}) that defines the offset of data in the current column
     * from the beginning of the row with data in bytes:
     * - at an offset measured from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader
     * and calculated by the following formula: COLUMN_DATA_OFFSET_OFFSET +
     * + column index * (8 + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})) +
     * + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader.
     */
    long COLUMN_DATA_OFFSET_OFFSET = 8L;

    /**
     * For every table column, the sas7bdat file stores the denotation (in bytes) of data length in a column:
     * - at an offset measured from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader
     * and calculated by the following formula: COLUMN_DATA_LENGTH_OFFSET +
     * + column index * (8 + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})) +
     * + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader,
     * - with the length of {@link SasFileConstants#COLUMN_DATA_LENGTH_LENGTH} bytes.
     */
    long COLUMN_DATA_LENGTH_OFFSET = 8L;

    /**
     * For every table column, the sas7bdat file stores the denotation (in bytes) of data length in a column:
     * - at an offset measured from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader
     * and calculated by the following formula: {@link SasFileConstants#COLUMN_DATA_LENGTH_OFFSET} +
     * + column index * (8 + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})) +
     * + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader,
     * - with the length of COLUMN_DATA_LENGTH_LENGTH bytes.
     */
    int COLUMN_DATA_LENGTH_LENGTH = 4;

    /**
     * For every table column, the sas7bdat file stores the data type of a column:
     * - with the length of {@link SasFileConstants#COLUMN_TYPE_LENGTH} bytes.
     * - at an offset measured from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader
     * and calculated by the following formula: COLUMN_TYPE_OFFSET +
     * + column index * (8 + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})) +
     * + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader,
     * If type=1, then the column stores numeric values, if type=0, the column stores text.
     */
    long COLUMN_TYPE_OFFSET = 14L;

    /**
     * For every table column, the sas7bdat file stores the data type of a column:
     * - with the length of COLUMN_TYPE_LENGTH bytes.
     * - at an offset measured from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader
     * and calculated by the following formula: {@link SasFileConstants#COLUMN_TYPE_OFFSET} +
     * + column index * (8 + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})) +
     * + the size of value type (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.ColumnAttributesSubheader} subheader,
     * If type=1, then the column stores numeric values, if type=0, the column stores text.
     */
    int COLUMN_TYPE_LENGTH = 1;

    /**
     * For every table column, the sas7bdat file stores the index of
     * the {@link SasFileParser.ColumnTextSubheader} whose text block stores the column format:
     * - with the length of {@link SasFileConstants#COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_LENGTH} bytes,
     * - at an offset calculated as COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_OFFSET bytes +
     * + 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from
     * the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_OFFSET = 22L;

    /**
     * For every table column, the sas7bdat file stores the index of the
     * {@link SasFileParser.ColumnTextSubheader} whose text block stores the column format:
     * - with the length of COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_LENGTH bytes,
     * - at an offset calculated as {@link SasFileConstants#COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_OFFSET} bytes +
     * + 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from
     * the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the offset (in symbols) of the column format from
     * the beginning of the text block of the {@link SasFileParser.ColumnTextSubheader} subheader
     * where it belongs:
     * - with the length of {@link SasFileConstants#COLUMN_FORMAT_OFFSET_LENGTH} bytes,
     * - at an offset calculated as COLUMN_FORMAT_OFFSET_OFFSET bytes + 3 * the size of value types
     * (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from the beginning of
     * the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_FORMAT_OFFSET_OFFSET = 24L;

    /**
     * For every table column, the sas7bdat file stores the offset (in symbols) of the column format from
     * the beginning of the text block of the {@link SasFileParser.ColumnTextSubheader}
     * subheader where it belongs:
     * - with the length of COLUMN_FORMAT_OFFSET_LENGTH bytes,
     * - at an offset calculated as {@link SasFileConstants#COLUMN_FORMAT_OFFSET_OFFSET} bytes +
     * + 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from
     * the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_FORMAT_OFFSET_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the column format length (in symbols):
     * - with the length of {@link SasFileConstants#COLUMN_FORMAT_LENGTH_LENGTH} bytes,
     * - at an offset calculated as COLUMN_FORMAT_LENGTH_OFFSET bytes + the size of three value types
     * (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from the beginning of
     * the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_FORMAT_LENGTH_OFFSET = 26L;

    /**
     * For every table column, the sas7bdat file stores the column format length (in symbols):
     * - with the length of COLUMN_FORMAT_LENGTH_LENGTH bytes,
     * - at an offset calculated as {@link SasFileConstants#COLUMN_FORMAT_LENGTH_OFFSET} bytes +
     * 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_FORMAT_LENGTH_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the index of the
     * {@link SasFileParser.ColumnTextSubheader} subheader
     * whose text block contains the column label:
     * - with the length of {@link SasFileConstants#COLUMN_LABEL_TEXT_SUBHEADER_INDEX_LENGTH} bytes,
     * - at an offset calculated as COLUMN_LABEL_TEXT_SUBHEADER_INDEX_OFFSET bytes +
     * + 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from
     * the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_LABEL_TEXT_SUBHEADER_INDEX_OFFSET = 28L;

    /**
     * For every table column, the sas7bdat file stores the index of the
     * {@link SasFileParser.ColumnTextSubheader} subheader
     * whose text block contains the column label:
     * - with the length of COLUMN_LABEL_TEXT_SUBHEADER_INDEX_LENGTH bytes,
     * - at an offset equal to {@link SasFileConstants#COLUMN_LABEL_TEXT_SUBHEADER_INDEX_OFFSET} bytes +
     * + 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_LABEL_TEXT_SUBHEADER_INDEX_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the column label`s offset (in symbols) from the beginning of
     * the text block where it belongs (see {@link SasFileConstants#COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_OFFSET}):
     * - with the length of {@link SasFileConstants#COLUMN_LABEL_OFFSET_LENGTH} bytes.
     * - at an offset equal to COLUMN_LABEL_OFFSET_OFFSET bytes + 3 * the size of value types (int or long
     * depending on {@link SasFileConstants#ALIGN_2_VALUE}) from the beginning of
     * the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_LABEL_OFFSET_OFFSET = 30L;

    /**
     * For every table column, the sas7bdat file stores the column label`s offset (in symbols) from the beginning of
     * the text block where it belongs (see {@link SasFileConstants#COLUMN_FORMAT_TEXT_SUBHEADER_INDEX_OFFSET}):
     * - with the length of COLUMN_LABEL_OFFSET_LENGTH bytes.
     * - at an offset equal to {@link SasFileConstants#COLUMN_LABEL_OFFSET_OFFSET} bytes + 3 * the size
     * of value types(int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from the beginning of the
     * {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_LABEL_OFFSET_LENGTH = 2;

    /**
     * For every table column, the sas7bdat file stores the length of the column label (in symbols):
     * - with the length of {@link SasFileConstants#COLUMN_LABEL_LENGTH_LENGTH} bytes.
     * - at an offset calculated as COLUMN_LABEL_LENGTH_OFFSET bytes +
     * 3 * the size of value types (int or long depending on {@link SasFileConstants#ALIGN_2_VALUE})
     * from the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    long COLUMN_LABEL_LENGTH_OFFSET = 32L;

    /**
     * For every table column, the sas7bdat file stores the length of the column label (in symbols):
     * - with the length of COLUMN_LABEL_LENGTH_LENGTH bytes.
     * - at an offset calculated as {@link SasFileConstants#COLUMN_LABEL_LENGTH_OFFSET} bytes +
     * 3 * the size of value types(int or long depending on {@link SasFileConstants#ALIGN_2_VALUE}) from
     * the beginning of the {@link SasFileParser.FormatAndLabelSubheader} subheader.
     */
    int COLUMN_LABEL_LENGTH_LENGTH = 2;

    /**
     * Accuracy to define whether the numeric result of {@link SasFileParser#convertByteArrayToNumber(byte[])} is
     * a long or double value.
     */
    double EPSILON = 1E-14;

    /**
     * Accuracy to define whether the numeric result of {@link SasFileParser#convertByteArrayToNumber(byte[])} is NAN.
     */
    double NAN_EPSILON = 1E-300;

    /**
     * The number of milliseconds in a second.
     */
    long MILLISECONDS_IN_SECONDS = 1000L;

    /**
     * The number of seconds in a minute.
     */
    int SECONDS_IN_MINUTE = 60;

    /**
     * The number of minutes in an hour.
     */
    int MINUTES_IN_HOUR = 60;

    /**
     * The number of hours in a day.
     */
    int HOURS_IN_DAY = 24;

    /**
     * The number of days in a non-leap year.
     */
    int DAYS_IN_YEAR = 365;

    /**
     * The difference in days between 01/01/1960 (the dates starting point in SAS) and 01/01/1970 (the dates starting
     * point in Java).
     */
    int START_DATES_DAYS_DIFFERENCE = DAYS_IN_YEAR * 10 + 3;

    /**
     * The difference in seconds between 01/01/1960 (the dates starting point in SAS) and 01/01/1970 (the dates starting
     * point in Java).
     */
    int START_DATES_SECONDS_DIFFERENCE = SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY
            * START_DATES_DAYS_DIFFERENCE;

    /**
     * The date formats to store the day, month, and year. Appear in the data of the
     * {@link SasFileParser.FormatAndLabelSubheader} subheader and are stored in {@link Column#format}.
     */
    List<String> DATE_FORMAT_STRINGS = Arrays.asList("DATE",
                                        "YYMMDD", "YYMMDDB", "YYMMDDC", "YYMMDDD", "YYMMDDN", "YYMMDDP", "YYMMDDS",
                                        "MMDDYY", "MMDDYYB", "MMDDYYC", "MMDDYYD", "MMDDYYN", "MMDDYYP", "MMDDYYS",
                                        "DDMMYY", "DDMMYYB", "DDMMYYC", "DDMMYYD", "DDMMYYN", "DDMMYYP", "DDMMYYS",
                                        "MMYY", "MMYYC", "MMYYD", "MMYYN", "MMYYP", "MMYYS",
                                        "YYMM", "YYMMC", "YYMMD", "YYMMN", "YYMMP", "YYMMS",
                                        "MONYY",
                                        "YYMON");

    /**
     * The date formats to store the day, month, year, hour, minutes, seconds, and milliseconds. Appear in the data
     * of the {@link SasFileParser.FormatAndLabelSubheader} subheader and are stored in {@link Column#format}.
     */
    List<String> DATE_TIME_FORMAT_STRINGS = Collections.singletonList("DATETIME");
}
