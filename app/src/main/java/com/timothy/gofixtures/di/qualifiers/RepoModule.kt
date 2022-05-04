package com.timothy.gofixtures.di.qualifiers

import com.timothy.gofixtures.data.repository.FixturesRepoImpl
import com.timothy.gofixtures.domain.repository.FixturesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun provideRepo(fixturesRepoImpl: FixturesRepoImpl): FixturesRepo
}