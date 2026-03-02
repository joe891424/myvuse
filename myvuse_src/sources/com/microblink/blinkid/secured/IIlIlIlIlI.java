package com.microblink.blinkid.secured;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
abstract class IIlIlIlIlI<T> {
    private final int IlIllIlIIl;
    private final Type llIIlIlIIl;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: line */
    static class IlIllIlIIl<T> extends IIlIlIlIlI<T> {
        IlIllIlIIl(Class<T> cls) {
            super(cls);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof IIlIlIlIlI) && this.llIIlIlIIl.equals(((IIlIlIlIlI) obj).llIIlIlIIl);
    }

    public int hashCode() {
        return this.IlIllIlIIl;
    }

    public Type llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeReference<");
        llIIlIlIIl(this.llIIlIlIIl, sb);
        sb.append(">");
        return sb.toString();
    }

    protected IIlIlIlIlI() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.llIIlIlIIl = type;
        if (llIIlIlIIl(type)) {
            throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
        }
        this.IlIllIlIIl = type.hashCode();
    }

    public static boolean llIIlIlIIl(Type type) {
        if (type == null) {
            return false;
        }
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getTypeParameters().length != 0) {
                return true;
            }
            return llIIlIlIIl(cls.getDeclaringClass());
        }
        if (!(type instanceof ParameterizedType)) {
            if (!(type instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            return llIIlIlIIl(wildcardType.getLowerBounds()) || llIIlIlIIl(wildcardType.getUpperBounds());
        }
        for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
            if (llIIlIlIIl(type2)) {
                return true;
            }
        }
        return false;
    }

    private IIlIlIlIlI(Type type) {
        this.llIIlIlIIl = type;
        if (!llIIlIlIIl(type)) {
            this.IlIllIlIIl = type.hashCode();
            return;
        }
        throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
    }

    private static void llIIlIlIIl(Type type, StringBuilder sb) {
        if (type == null) {
            return;
        }
        if (type instanceof TypeVariable) {
            sb.append(((TypeVariable) type).getName());
            return;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            sb.append(cls.getName());
            llIIlIlIIl(cls.getTypeParameters(), sb);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            sb.append(((Class) parameterizedType.getRawType()).getName());
            llIIlIlIIl(parameterizedType.getActualTypeArguments(), sb);
        } else if (type instanceof GenericArrayType) {
            llIIlIlIIl(((GenericArrayType) type).getGenericComponentType(), sb);
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            sb.append(type.toString());
        }
    }

    private static void llIIlIlIIl(Type[] typeArr, StringBuilder sb) {
        if (typeArr == null || typeArr.length == 0) {
            return;
        }
        sb.append("<");
        for (int i = 0; i < typeArr.length; i++) {
            llIIlIlIIl(typeArr[i], sb);
            if (i != typeArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
    }

    private static boolean llIIlIlIIl(Type[] typeArr) {
        if (typeArr == null) {
            return false;
        }
        for (Type type : typeArr) {
            if (llIIlIlIIl(type)) {
                return true;
            }
        }
        return false;
    }
}
