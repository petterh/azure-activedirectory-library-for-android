// Copyright (c) Microsoft Corporation.
// All rights reserved.
//
// This code is licensed under the MIT License.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.microsoft.aad.adal.testapp;

import com.microsoft.aad.adal.IDeviceCertificate;

import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/**
 * This class will be used from ADAL after getting the classname from
 * AuthenticationSettings. WPJ class will be referenced inside the authenticator
 * not inside the public ADAL. If class is loaded at Authenticator's process, it
 * will access the WPJ API.
 */
public class MockDeviceCertProxy implements IDeviceCertificate {

    static X509Certificate sCertificate = null;

    static RSAPrivateKey sPrivateKey = null;

    static RSAPublicKey sPublicKey = null;

    static String sThumbPrint = null;

    static boolean sValidIssuer = false;

    public static void reset() {
        sCertificate = null;
        sPrivateKey = null;
        sPublicKey = null;
        sThumbPrint = null;
        sValidIssuer = false;
    }

    @Override
    public X509Certificate getCertificate() {
        return sCertificate;
    }

    @Override
    public RSAPrivateKey getRSAPrivateKey() {
        return sPrivateKey;
    }

    public RSAPublicKey getRSAPublicKey() {
        return sPublicKey;
    }

    @Override
    public String getThumbPrint() {
        return sThumbPrint;
    }

    @Override
    public boolean isValidIssuer(List<String> certAuthorities) {
        // TODO Auto-generated method stub
        return sValidIssuer;
    }
}
