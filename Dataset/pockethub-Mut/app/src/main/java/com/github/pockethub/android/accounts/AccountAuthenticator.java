/*
 * Copyright (c) 2015 PocketHub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pockethub.android.accounts;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.github.pockethub.android.BuildConfig;
import static android.accounts.AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE;
import static android.accounts.AccountManager.KEY_BOOLEAN_RESULT;
import static android.accounts.AccountManager.KEY_INTENT;
import static com.github.pockethub.android.BuildConfig.ACCOUNT_TYPE;
import static com.github.pockethub.android.accounts.LoginActivity.PARAM_AUTHTOKEN_TYPE;
import static com.github.pockethub.android.accounts.LoginActivity.PARAM_USERNAME;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class AccountAuthenticator extends AbstractAccountAuthenticator {

    private Context context;

    public AccountAuthenticator(final Context context) {
        super(context);
        if (!ListenerUtil.mutListener.listen(0)) {
            this.context = context;
        }
    }

    /**
     * The user has requested to add a new account to the system. We return an
     * intent that will launch our login screen if the user has not logged in
     * yet, otherwise our activity will just pass the user's credentials on to
     * the account manager.
     */
    @Override
    public Bundle addAccount(final AccountAuthenticatorResponse response, final String accountType, final String authTokenType, final String[] requiredFeatures, final Bundle options) throws NetworkErrorException {
        final Intent intent = new Intent(context, LoginActivity.class);
        if (!ListenerUtil.mutListener.listen(1)) {
            intent.putExtra(PARAM_AUTHTOKEN_TYPE, authTokenType);
        }
        if (!ListenerUtil.mutListener.listen(2)) {
            intent.putExtra(KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
        }
        final Bundle bundle = new Bundle();
        if (!ListenerUtil.mutListener.listen(3)) {
            bundle.putParcelable(KEY_INTENT, intent);
        }
        return bundle;
    }

    @Override
    public Bundle confirmCredentials(final AccountAuthenticatorResponse response, final Account account, final Bundle options) {
        return null;
    }

    @Override
    public Bundle editProperties(final AccountAuthenticatorResponse response, final String accountType) {
        return null;
    }

    @Override
    public Bundle getAuthToken(final AccountAuthenticatorResponse response, final Account account, final String authTokenType, final Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public String getAuthTokenLabel(final String authTokenType) {
        if (ACCOUNT_TYPE.equals(authTokenType)) {
            return authTokenType;
        } else {
            return null;
        }
    }

    @Override
    public Bundle hasFeatures(final AccountAuthenticatorResponse response, final Account account, final String[] features) throws NetworkErrorException {
        final Bundle result = new Bundle();
        if (!ListenerUtil.mutListener.listen(4)) {
            result.putBoolean(KEY_BOOLEAN_RESULT, false);
        }
        return result;
    }

    @Override
    public Bundle updateCredentials(final AccountAuthenticatorResponse response, final Account account, final String authTokenType, final Bundle options) {
        final Intent intent = new Intent(context, LoginActivity.class);
        if (!ListenerUtil.mutListener.listen(5)) {
            intent.putExtra(PARAM_AUTHTOKEN_TYPE, authTokenType);
        }
        if (!ListenerUtil.mutListener.listen(6)) {
            intent.putExtra(KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
        }
        if (!ListenerUtil.mutListener.listen(8)) {
            if (!TextUtils.isEmpty(account.name)) {
                if (!ListenerUtil.mutListener.listen(7)) {
                    intent.putExtra(PARAM_USERNAME, account.name);
                }
            }
        }
        final Bundle bundle = new Bundle();
        if (!ListenerUtil.mutListener.listen(9)) {
            bundle.putParcelable(KEY_INTENT, intent);
        }
        return bundle;
    }
}
